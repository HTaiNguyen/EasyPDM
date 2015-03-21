/**
 *	Code qui s'éxécute une fois que tous les élément de la page est chargée
 */

$(window).load(function() {
	var windowHeight = $(window).height();
	$("#page").css("height", windowHeight);
	
	var connectionHeight = $("#connection").height();
	$("#connection").css("margin-top", -connectionHeight / 2);
	
	var headerHeight = $("header").height();
	var navigationHeight = $("nav").height();
	var footerHeight = $("footer").height();
	$("#content").css("height", windowHeight - headerHeight - navigationHeight - footerHeight);

	var titleHeight = $("#title").height();
	$("#split").css("height", windowHeight - headerHeight - navigationHeight - titleHeight - footerHeight - 2);	
});

/**
 *	Code qui s'éxécute lorsque la page est redimensionnée
 */
 
$(window).resize(function() {
	var windowHeight = $(window).height();
	$("#page").css("height", windowHeight);
	
	var connectionHeight = $("#connection").height();
	$("#connection").css("margin-top", -connectionHeight / 2);
	
	var headerHeight = $("header").height();
	var navigationHeight = $("nav").height();
	var footerHeight = $("footer").height();
	$("#content").css("height", windowHeight - headerHeight - navigationHeight - footerHeight);
	
	var titleHeight = $("#title").height();
	$("#split").css("height", windowHeight - headerHeight - navigationHeight - titleHeight - footerHeight - 2);	
});

/**
 *	Code qui s'éxécute une fois la page HTML est chargée
 */
 
$(document).ready(function() {
    $('.treeview').treeView();
    $('.treeview').treeView('collapseAll'); //expandAll or collapseAll

    $(".treeview .menu1").contextMenu({
        menu: 'menu1'
    },
    function(action, el, pos) {
        switch (action) {
            case "upload":
                $("#upload_form").dialog({
                    resizable: false,
                    height: 200,
                    width: 500,
                    modal: true
                });
                
                break;
            default:
                break;
        }
    });
    
    $(".treeview .menu2").contextMenu({
        menu: 'menu2'
    },
    function(action, el, pos) {
        switch (action) {
            case "download":
                var e_id = 19;
                
                $.ajax({
                    url : 'DownloadServlet',
                    type : 'POST',
                    data: {
                        'e_id': e_id
                    },
                    success : function() {
                        
                    }
                });
                
                break;
            default:
                break;
        }
    });
});