/**
 * 
 */

 $(document).ready(function(){
	$('#formSubmitted').submit(function(){
		if($('#campoNombre').val()==0){
			alert("Debe seleccionar un nombre de usuario")
			$('#campoNombre').focus()
			return false
		}else{
			alert("todo esta correcto")
			return true
		}
		
		
	});	
});

// El código proporcionado es JQuery, 
// pero si lo deseas puedes remplazar 
// $('#campoNombre').focus()
// por la llamada a una fucnión que ejecutase:
// document.getElementById('campoNombre').focus() 
