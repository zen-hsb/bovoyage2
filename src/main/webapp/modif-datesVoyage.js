function verifier() {
	let ok = true;
	
	ok = ok & !isEmpty(document.getElementById('region')); 
	ok = ok & !isEmpty('description');
	
	if(!ok){
		event.preventDefault(); 					//n'envoie pas le formulaire si champ vide
	}							
	return ok;
}


function isEmpty(inputElt){
	let err = document.getElementById("error_"+inputElt.name);	
	err.style.visibility = "hidden";
	if(inputElt.value.trim().length == 0) {					
		err.style.visibility = "visible";
		err.innerText = "Ce champ est obligatoire";
		return true;
	}
//	err.style.visibility = "hidden";
	return false;
}


function isLengthMin(inputElt) {				
	let err = document.getElementById("error_"+inputElt.name);
	err.style.visibility = "hidden";
	if(inputElt.value.trim().length <= 10) {
		err.style.visibility = "visible";
		err.innerText = "Il faut au minimum 10 caractères !";
		return false;
	}
	return true;
}


document.addEventListener("DOMContentLoaded",function(){	
	let blurs = document.getElementsByClassName("blur");
	for(let i=0 ; i<blurs.length ; i++){
		blurs[i].addEventListener("blur",function(evt){isEmpty(evt.target)});
	}
	document.getElementById("formId").addEventListener("submit",verifier);								
	document.getElementById("description").addEventListener("blur",function(evt){isLengthMin(evt.target,10)}); 
});
