<!DOCTYPE html>
<html>
<head>

</head>
<body>


<h2>Cadastrar Produtos</h2>
<p/>
	<form method="post" action="Controle?cmd=gravar">
		Nome produto:<br/>
		<input type="text" name="nome" value=""	size="35"
		required="required" placeholder="Entre com o produto"
		title="Entre com Produto com Letras"
		pattern="[a-z A-Z]+"
		/><br/><br/>
		
		preco:<br/>
		<input type="text" name="preco" value=""	size="10"
		required="required" placeholder="Entre com o preco"
		title="Entre com numeros"
		pattern="[0-9\\.]+"
		/><br/><br/>
		
		Quntidade:<br/>
		<input type="number" name="quantidade" value=""	size="10"
		required="required" placeholder="Entre com o quntidade"
		title="Entre com numero"
		
		/><br/><br/>
		
		<input type="submit" name="btn" value="Enviar"/><br/><br/>
		
	</form>

</body>
</html>