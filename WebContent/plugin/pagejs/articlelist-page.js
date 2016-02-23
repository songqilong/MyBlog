$(document).ready(function(){
	// 遍历class为item-content的元素
	$(".item-content").each(function(){
		// 获取每个元素中的文本，然后截取150个字符
		var articleContent = $(this).text().substr(0,150)+"......";
		// 将每个元素的样式设为默认样式
		$(this).text(articleContent).css({"style":"none"});
	});
	
	var aid = 0;
	$('.delete').click(function(){
		aid = $(this).parent().parent().parent().attr("id");
		$('#load-modal').load("/Blog/view/modal.jsp #model-delete",function(){
			$('#model-delete').modal('show');
			
			$('#delete').on("click",function(){
				$.post("/Blog/article/article_delete",{aid:aid},function(data){
					if("deleteSuccess" == data){
						var TotalArticleQty = $('#TotalArticleQty').text();
						$('#TotalArticleQty').text(parseInt(TotalArticleQty)-1);
						$('#model-delete').modal('hide');
						$("#"+aid).remove();
					}
				});
			});
		});

	});
	
	
});