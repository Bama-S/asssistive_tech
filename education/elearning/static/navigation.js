var i = 1;                  //  set your counter to 1
var buttons = document.getElementsByTagName('input');
// var buttons = document.querySelectorAll('input[type=radio]')
console.log(buttons)
console.log(typeof(buttons))
var new_buttons = {}
var count = []
// for (const button in buttons){
// 	console.log(buttons[button])
// }
// buttons = buttons.filter(item => !(item.type == hidden));
var body = document.getElementById('body');
var buttonLen=0;
var buttonId = 0 ;


// function clickOnEnter(event) {
// 	if (event.key === 'Enter') {
// 	  const focusedButton = document.activeElement;
// 	  if (focusedButton.tagName === 'button'|| (focusedElement.tagName === 'input' && focusedElement.type === 'radio')) {
// 		focusedButton.click();
// 	  }
// 	}
//   }

//   document.addEventListener('mousedown', function(event) {
// 	// if (event.key === 'Enter') {
// 	  var focusedElement = document.activeElement;
// 	  if ((event.button === 0 && focusedElement && focusedElement.tagName === 'INPUT' && focusedElement.type === 'radio')) {
// 		event.preventDefault();
// 		console.log(focusedElement.type)
// 		focusedElement.checked = true;
// 	  }
// 	//   else if (focusedElement && focusedElement.tagName === 'SELECT'){
// 	// 	var options = focusedElement.options;
// 	// 	for (var j = 0; j < options.length; j++){
// 	// 		var focusedOption = event.target;
// 	// 		if (focusedOption.tagName === 'OPTION'){
// 	// 			focusedOption.selected = true;
// 	// 		}
// 	// 	}
// 	//   }
// 	  else if (event.button === 0 && focusedElement && focusedElement.tagName === 'INPUT'){
// 		// focusedElement.click();
// 		event.target.click();
// 	  }
	  
// 	}
//   );


// var focusedButton = null;
// document.addEventListener("focus", function(event){
// 	focusedButton = event.target;
// })

// document.addEventListener("blur", function(event){
// 	focusedButton = null;
// })

// function handleClick(event) {
// 	if (event.button === 0 && focusedButton) {
// 	  focusedButton.click();
//   }
//   }

// document.addEventListener('mousedown', handleClick);



// document.addEventListener('focusin', function(event) {
//   if (event.target.tagName === 'BUTTON') {
//     focusedButton = event.target;
//   }
// });

// document.addEventListener('focusout', function(event) {
//   if (event.target === focusedButton) {
//     focusedButton = null;
//   }
// });

document.addEventListener('mousedown', function(event) {
	var focusedButton = document.activeElement;	
	console.log(focusedButton)
  
  if ((focusedButton && focusedButton.tagName === 'INPUT' && focusedButton.type === 'radio')) {
			event.preventDefault();
			console.log(focusedButton.type)
			focusedButton.checked = true;
  }
  else if (focusedButton) {
    focusedButton.click();
	event.preventDefault();
  }
});

function display(){
	console.log(typeof(buttons[buttonId]))

	Object.keys(buttons).forEach(function(button) {

		// console.log(buttons[button]);
		if (buttons[button].type != 'hidden'){
			new_buttons[button] = buttons[button]
			count.push(button)

		}
	  
	  });
	  buttonLen = Object.keys(new_buttons).length;
	  console.log(count)
	
	// for (const button in buttons){
	// 	if (button.type != 'hidden'){
	// 		console.log(typeof(button))
	// 		new_buttons.push(button)
	// 	}
	// }

}
function looping() { 	

    // console.log("inside looping");      //  create a loop function
  setTimeout(function() {   //  call a 3s setTimeout when the loop is called
       //  your code here
	   console.log(buttonLen)
	   if (buttonId==buttonLen){
		buttonId=0;
	   }


	   console.log(buttonId);
	//    body.addEventListener('contextmenu', (e) => {
	// 	e.preventDefault();
	//  });
	//  body.addEventListener('mouseup', (e) => {            
	// 	if (e.button == 0) {
	// 		buttons[buttonId].click();
	// 	}
		   
	//  });


	   console.log(new_buttons[count[buttonId]])
		new_buttons[count[buttonId]].focus();
		// new_buttons[count[buttonId]].addEventListener('focus', clickOnEnter);

		// buttons[i].addEventListener('focus', function(event) {
		// 	event.target.addEventListener('keydown', function(event) {
		// 	  if (event.key === 'Enter') {
		// 		event.target.click();
		// 	  }
		// 	}

	   

	   
	   new_buttons[count[buttonId++]];
    i++;                    
      looping();                                 
  }, 3000)
}



onload = function () {
    console.log("inside onload");
	// if ('speechSynthesis' in this.window) {
	// 	var synth = speechSynthesis;
	// 	var flag = false;

	// 	/* references to the buttons */
	// 	var playEle = document.querySelector('#play');
	// 	var pauseEle = document.querySelector('#pause');
	// 	var stopEle = document.querySelector('#stop');
	// 	var eval = document.querySelector('#evaluate');
	// 	/* click event handlers for the buttons */
	// 	playEle.addEventListener('click', onClickPlay);
	// 	pauseEle.addEventListener('click', onClickPause);
	// 	stopEle.addEventListener('click', onClickStop);
	// 	eval.addEventListener('click',onClickEvaluate);
	// 	function onClickPlay() {
	// 		if (!flag) {
	// 			flag = true;
	// 			// utterance = new SpeechSynthesisUtterance(
	// 			//       document.querySelector('article').textContent);
	// 			utterance = new SpeechSynthesisUtterance(
	// 				document.querySelector('#question').textContent);
	// 			utterance.voice = synth.getVoices()[0];
	// 			utterance.onend = function () {
	// 				flag = false;
	// 			};
	// 			synth.speak(utterance);
	// 		}
	// 		if (synth.paused) { /* unpause/resume narration */
	// 			synth.resume();
	// 		}
	// 	}

	// 	function onClickEvaluate() {
	// 		if (!flag) {
	// 			flag = true;
				
	// 			utterance1 = new SpeechSynthesisUtterance(
	// 				document.querySelector('#result').textContent);
	// 			utterance1.voice = synth.getVoices()[0];
	// 			utterance1.onend = function () {
	// 				flag = false;
	// 			};
	// 			synth.speak(utterance1);
	// 		}
			
	// 	}
		
	// 	function onClickPause() {
	// 		if (synth.speaking && !synth.paused) { /* pause narration */
	// 			synth.pause();
	// 		}
	// 	}
	// 	function onClickStop() {
	// 		if (synth.speaking) { /* stop narration */
	// 			/* for safari */
	// 			flag = false;
	// 			synth.cancel();
	// 		}
	// 	}
	// }
	// else {

	// }
	display();
	looping();

// 	var buttons = document.getElementsByTagName('button');
// 			while (1){
// 				for (elem of buttons){
// // 				//sleep(2000);
// 				for (var i = 0; i < 1000; i++);
//  				console.log(elem);
//  				elem.focus()
// 			}
// }

}