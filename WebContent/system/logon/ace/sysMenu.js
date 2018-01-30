(function ($) {
    $.fn.sidebarMenu = function (options) {
        options = $.extend({}, $.fn.sidebarMenu.defaults, options || {});
        var $menu_ul = $(this);
        var level = 0;
        if (options.data) {
            init($menu_ul, options.data, level);
        }
        else {
            if (!options.url) {
            	return;
            }
            $.getJSON(options.url, options.param, function (data) {
                init($menu_ul, data, level);
            });
        }

        function init($menu_ul, data, level) {
            $.each(data, function (i, item) {
                //如果不是header
                var li = $('<li></li>');
                //a标签
                var $a = $('<a></a>');

                //图标
                var $icon = $('<i></i>');
                if (level === 1) {
                	$icon.addClass('icon-double-angle-right');
                } else {
                	$icon.addClass(item.iconCls);
                }

                //标题
                var $title = $('<span ></span>');
                $title.addClass('menu-text').text(item.text);

                $a.append($icon);
                $a.append($title);
                
                var isOpen = item.isOpen;

                if (isOpen === true) {
                    li.addClass("active");
                }
                if (item.children && item.children.length > 0) {
                	var $parentMenu = '<b class="arrow icon-angle-down"></b>';
                	$a.addClass("dropdown-toggle");
                    $a.append($parentMenu);
                    li.append($a);

                    var menus = $('<ul></ul>');
                    menus.addClass('submenu');
                    init(menus, item.children, level + 1);
                    li.append(menus);
                }
                else {
                	var href = 'javascript:addTabs({id:\'' + item.id + '\',title: \'' + item.text + '\',close: false,url: \'' + item.url + '\'});';
                	$a.attr('href', href);
                    li.append($a);
                }
                $menu_ul.append(li);
            });
        }
    };

    $.fn.sidebarMenu.defaults = {
        url: null,
        param: null,
        data: null,
    };
})(jQuery);

//sidebar - menu组件封装
//在页面上面直接调用sidebar - menu的方法

//绑定的菜单事件
var addTabs = function (options) {
	window.main.addTab(options.id, options.title, options.url);
}