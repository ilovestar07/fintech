<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <title></title>
	    <%@ include file="/system/logon/ace/public.jsp" %>
	    <script type='text/javascript' charset='utf-8'>
	        var tabView = new YAHOO.widget.TabView();
	        var tabHeight;
	        //最多打开tab个数
	        var tabNum = 8;
	        init = function() {
	            tabView.appendTo('yuicontainer');
	            addTab('0', '首页', 'system/logon/ace/home.jsp');
	        }
	
	        addTab = function(id,label,src) {
	            //同一菜单只允许打开一次,多次打开视为切换tab页
	            for(var tabIndex=0;tabIndex<tabView.get("tabs").length;tabIndex++) {
	                var tab=tabView.getTab(tabIndex);
	                if(tab.get("id")==id){
	                    tabView.set('activeTab',tab,true);
	                    return;
	                }
	            }
	
	            //判断是否tab个数达到限定个数
	            if(tabView.get("tabs").length == tabNum) {
	                if(!confirm("打开窗口个数已经达到"+tabNum+"个,新开窗口将会关闭第一个窗口,是否继续?")) {
	                    return;
	                }
	                //删除第一个窗口
	                tabView.removeTab(tabView.getTab("0"));
	            }
	            var labelText = label;
	            var content = '<div class="iframe_container"><div id="tobarDiv'+id+'" class="tobarDiv"></div><iframe class="tabFrame" id="iFrame'+id+'" name="iFrame'+id+'" frameBorder=0 scrolling="auto" width="100%" height="100%" resizeable="yes"  src="'+src+'"></iframe></div>';
	            var tab = new YAHOO.widget.Tab({ label: labelText,content:content });
	            tabView.addTab(tab);
	            tabView.set('activeTab',tab,true);
	            tab.set('title',labelText);
	            tab.set("id",id);
	            tab.addListener('dblclick',dblClickEvent);
	        }
	        //双击TAB头关闭事件
	        function dblClickEvent(e) {
	            var tab=tabView.get('activeTab');
	            var id=tab.get("id");
	            if (id == '0') {
	            	return;
	            }
	            document.getElementById("iFrame"+id).src="";
	            tabView.removeTab(tab);
	        }
	
	        //获取当前TAB的resource_id
	        function getResourceId() {
	            if(tabView.get('activeTab')) {
	                return tabView.get('activeTab').get("id");
	            } else {
	                return null;
	            }
	        }
	
	        function closeTab(tabId) {
	            for(var tabIndex=0;tabIndex<tabView.get("tabs").length;tabIndex++){
	                var tab=tabView.getTab(tabIndex);
	                if(tab.get("id")==tabId){
	                    document.getElementById("iFrame"+tabId).src="";
	                    tabView.removeTab(tab);
	                    return;
	                }
	            }
	        }
	    </script>
	</head>
	<body onload="init();" style="margin:0;padding:0; background:#fff">
		<div id="yuicontainer"></div>
	</body>
</html>