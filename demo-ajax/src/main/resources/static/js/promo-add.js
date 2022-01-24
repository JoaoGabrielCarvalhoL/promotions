$("#linkPromocao").on('change', function(){
	
	let url = $(this).val();
	 
	if (url.length > 7) {
		$.ajax({
			method: "POST", 
			url: "/meta/info?url=" + url, 
			cache: false, 
			beforeSend: function() {
				$("#alert").removeClass("alert alert-danger alert-success").text("");
				$("#titulo").val("");
				$("#site").text("");
				$("#linkImagem").attr("src", "");
				$("#loader-img").addClass("loader");
			},
			success: function(data) {
				console.log(data);
				$("#titulo").val(data.titulo);
				$("#site").text(data.site.replace("@", ""));
				$("#linkImagem").attr("src", data.imagem);
			}, 
			statusCode: {
				404: function() {
					$("#alert").addClass("alert alert-danger").text("Nenhuma informação pode ser recuperada dessa url.");
					$("#linkImagem").attr("src", "/images/promo-dark.png");
				}
			}, 
			error: function() {
				$("#alert").addClass("alert alert-danger").text("A Url não pode ser processada! Verifique se a URL está correta!");
				$("#linkImagem").attr("src", "/images/promo-dark.png");
			}, 
			
			complete: function() {
				$("#loader-img").removeClass("loader");
			}
		})
	}
})



$("#form-add-promo").submit(function(evento) {
	evento.preventDefault();
	
	var promocao = {};
	promocao.linkPromocao = $("#linkPromocao").val();
	promocao.descricao = $("#descricao").val(); 
	promocao.preco = $("#preco").val(); 
	promocao.titulo = $("#titulo").val(); 
	promocao.categoria = $("#categoria").val(); 
	promocao.linkImage = $("#linkImagem").attr("src");
	promocao.site = $("#site").text();
	
	console.log("Promocao: ", promocao); 
	
	$.ajax({
		method: "POST", 
		url: "/promocao/save", 
		data: promocao, 
		beforeSend: function() {
			$("span").closest(".error-span").remove();
			$("#categoria").removeClass("is-invalid");
			$("#preco").removeClass("is-invalid");
			$("#linkPromocao").removeClass("is-invalid");
			$("#titulo").removeClass("is-invalid");
			$("#form-add-promo").hide();
			$("#loader-form").addClass("loader").show();
		},
		success: function() {
			$("#form-add-promo").each(function() {
				this.reset();
			});
			$("#linkImage").attr("src", "/images/promo-dark.png");
			$("#site").text("");
			$("#alert").removeClass("alert alert-danger").addClass("alert alert-success").text("Promoção cadastrada com sucesso!");
		}, 
		statusCode: {
			422: function(xhr) {
				console.log("Status error: ", xhr.status);
				var errors = $.parseJSON(xhr.responseText);
				$.each(errors, function(key, val){
					$("#" + key).addClass("is-invalid"); 
					$("#error-" + key).addClass("invalid-feedback").append("<span class='error-span'>" + val + "</span>")
				})
			}
		},
		error: function(xhr) {
			console.log("Error: ", xhr.responseText);
			$("#alert").addClass("alert alert-danger").text("Não foi possível cadastrar promocação!");
		}, 
		complete: function() {
			$("#loader-form").fadeOut(800, function() {
				$("#form-add-promo").fadeIn(250);
				$("#loader-form").removeClass("loader");
			})
		}
		
	})
});