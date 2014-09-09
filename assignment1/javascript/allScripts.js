//script to enter name
function enterName() {
			var first = prompt("Please enter your first name: ");
			var last = prompt("Please enter your last name: ");

			alert("Hello " + last + ", " + first + "! Welcome to IT353!");
}

//Number 2, script to calculate test scores
function calculateScores() {

		var numScores = parseInt(prompt("Enter total number of scores: "));

		var total = 0;
		var max = Number.MIN_VALUE;
		var min = Number.MAX_VALUE;
		var i;
		var scores = [];

		for(i = 0; i < numScores; i++){
			scores[i] = parseInt(prompt("Enter score: " ));
			total += scores[i];

			if(scores[i] > max)
				max = scores[i];

			if(scores[i] < min)
				min = scores[i];
		}

		var average = total/numScores;
		var aboveAverageIndex = 0;
		scores.sort();

		while(average < scores[aboveAverageIndex]){
			aboveAverageIndex++;
		}

		var results = "Lowest: " + min + "\nHighest: " + max + "\nAverage: " + average + "\nScores higher than average: " + parseInt(aboveAverageIndex + 1);
		alert(results);
		
		
	}
		