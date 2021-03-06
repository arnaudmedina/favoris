const
/**
 * Dans cet objet on conserve l'état de validité de chaque donnée
 */
valeursControleEtatCivil = {
		nom: false,
		prenom: false,
		numFixe: false,
		numMobile: false,

},
//Par fainénantise et pour reduire la taille de mon code,j'ai réuni tous les noms de champsEtatCivil dans ce tableau
champsEtatCivil = ['nom', 'prenom','numFixe', 'numMobile'];

//Fonction unique de vérification du formulaire
function changeListenerEtatCivil(event, firstCall) {
	if ("nom" == this.id ) {
		var re =/^([a-z]+(( |')[a-z]+)*)+([-]([a-z]+(( |')[a-z]+)*)+)*$/iu;
	};
	if ("prenom" == this.id ) {
		var re = /^([a-z]+(( |')[a-z]+)*)+([-]([a-z]+(( |')[a-z]+)*)+)*$/iu;
	}
	if ("numFixe" == this.id ) {
	   var re=/^(0|\+33)[1-9]([-. ]?[0-9]{2}){4}$/;
	}
	if ("numMobile" == this.id ) {
	var re=/^((\+|00)33\s?|0)[67](\s?\d{2}){4}$/u
	;
	}
	var OK = re.exec(this.value);
	if (!OK) { 
		valeursControleEtatCivil[this.id] = false;
	}
	else { 
		valeursControleEtatCivil[this.id]= true;
		//window.alert("Merci, votre mail est : " + OK[0]);
	}

	if (!firstCall) {
		if (valeursControleEtatCivil[this.id]) {
			this.classList.add('valide');
			this.classList.remove('error');
		} else {
			this.classList.add('error');
			this.classList.remove('valide');
		}
	}


//	Grise (ou pas) mon bouton submit
	let valeursControleEtatCivilDansTableau = Object.values(valeursControleEtatCivil),
	positionFalse = valeursControleEtatCivilDansTableau.indexOf(false);
	document.getElementById('valider').disabled = (-1 !== positionFalse);
}

//Callback qui me permet de déterminer que le document est censé être chargé donc utilisable
document.onreadystatechange = function () {
	// Ici j'attends que le document me dise qu'il est complétement chargé
	if ('complete' === document.readyState) {
		/**
		 * Ici je parcours tous mes champsEtatCivil les uns après les autres sans avoir besoin de recopier x fois le même code
		 * Moins de code dupliqué
		 *  = moins de code à maintenir
		 *  = moins de risque de bug dans le temps
		 */
		for (let champ of champsEtatCivil) {
			let inputTmp = document.getElementById(champ);

			inputTmp.addEventListener('change', changeListenerEtatCivil);
			changeListenerEtatCivil.call(inputTmp, undefined, true);
		}
	}
};