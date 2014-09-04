//script to enter name
function enterName() {
			var first = prompt("Please enter your first name: ");
			var last = prompt("Please enter your last name: ");

			alert("Hello " + last + ", " + first + "! Welcome to IT353!");
}

//Number 2, script to calculate test scores
function calculateScores() {
	var numScores = prompt("Enter the number of scores: ");

	var i, scores, min, max;

	for(i = 0; i < numScores; i++){
		var curr = prompt("Enter score number " + i ": ");

		scores += curr;
		if(curr > max)
			max = curr;

		if(curr < min)
			min = curr;

	}

	var results = "Lowest: " + min + "\nHighest: " + max + "\nAverage: " + scores/numScores;

}
		