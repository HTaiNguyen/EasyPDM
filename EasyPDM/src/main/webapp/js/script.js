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

    /*var $dataTree = $('#dataTree');
    var model = JSON.parse($('#treeModel').html());
    $dataTree.treeView(model);
    $('.treeview').treeView('collapseAll');*/

    $(".treeview .element").contextMenu({
        menu: 'menu'
    },
    function(action, el, pos) {
        switch (action) {
            case "download":
                var e_id = 18;
                
                $.ajax({
                    url : 'DownloadServlet',
                    type : 'POST',
                    data: {
                        'e_id': e_id
                    },
                    success : function(html) {
                        alert("fin download");
                    }
                });
                
                break;
            case "upload":
                /*$.ajax({
                    url : 'ProfileLoadPictures',
                    type : 'POST',
                    data: {
                        'page_number': page_number,
                        'user_id': user_id
                    },
                    success : function(html) {
                        
                    }
                });*/
                
                break;
            default:
                break;
        }
                
        alert(
        'Action: ' + action + '\n\n' +
        'Element ID: ' + $(el).attr('name') + '\n\n' +
        'X: ' + pos.x + '  Y: ' + pos.y + ' (relative to element)\n\n' +
        'X: ' + pos.docX + '  Y: ' + pos.docY+ ' (relative to document)'
        );
    });
});