//The root URL for the RESTful services
var rootURL = "http://localhost:8080/MarketPlace/rest/service";


// Register persons
$('#btnSearch').click(function() {
	search($('#searchKey').val());
	return false;
});

//Auto project assign
$('#btnAssign').click(function() {
	assign();
	return false;
});

//Initial data upload
$('#btnInitial').click(function() {
	initial();
	return false;
});

$('#projectList a').live('click', function() {
	findBidByProjectName($(this).data('identity'));
});

function search(searchKey) {
	if (searchKey == '') 
		findAll();
	else {
		findProjectByName(searchKey);
		findBidByName(searchKey);
	}
}


function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: renderList
	});
}

function assign() {
	$.ajax({
		type: 'POST',
		url: rootURL + '/assign',
		dataType: "json",
		//success: renderList 
	});
}

function initial() {
	$.ajax({
		type: 'POST',
		url: rootURL + '/initial',
		dataType: "json",
		//success: renderList 
	});
}

function findProjectByName(searchKey) {
	$.ajax({
		type: 'GET',
		url: rootURL + '/projects?name=' + searchKey,
		dataType: "json",
		success: renderList 
	});
}

function findBidByName(searchKey) {
	$.ajax({
		type: 'GET',
		url: rootURL + '/bidsByPerson?name=' + searchKey,
		dataType: "json",
		success: renderBidList 
	});
}

function findBidByProjectName(searchKey) {
	$.ajax({
		type: 'GET',
		url: rootURL + '/bidsByProject?projectName=' + searchKey,
		dataType: "json",
		success: renderBidList 
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	list = data.projects;
	list = data == null ? [] : list;


	$('#projectList tr').remove();

	$('#projectList').append('<tr>' + 
			'<td>Project Name</td>' + 
			'<td>Description</td>' + 
			'<td>Budget</td>' + 
			'<td>Ending Date</td>' + 
			'<td>Ower</td>' + 
			'<td>Assignee</td>' + 
			'</tr>');
	
	$.each(list, function(index, project) {
		//alert(index + ":" + project.projectName);
		$('#projectList').append('<tr>' + 
				'<td><a href="#" data-identity="' + project.projectName + '">'+ project.projectName+'</a></td>' + 
				'<td>' + project.description + '</td>' + 
				'<td>' + project.budget + '</td>' + 
				'<td>' + project.endingDate + '</td>' + 
				'<td>' + project.ownerName + '</td>' + 
				'<td>' + project.assigneeName + '</td>' + 
				'</tr>');
	});
}

function renderBidList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	list = data.bids;
	list = data == null ? [] : list;


	$('#bidList tr').remove();

	$('#bidList').append('<tr>' + 
			'<td>Engineer Name</td>' + 
			'<td>Project Name</td>' + 
			'<td>Proposal</td>' + 
			'<td>Amount</td>' + 
			'</tr>');
	
	$.each(list, function(index, bid) {
		//alert(index + ":" + bid.projectName + " " + bid.engineerName);
		$('#bidList').append('<tr>' + 
				'<td><a href="#" data-identity="' + bid.engineerName + ',' + bid.projectName + '">'+ bid.engineerName+'</a></td>' + 
				'<td>' + bid.projectName + '</td>' + 
				'<td>' + bid.proposal + '</td>' + 
				'<td>' + bid.amount + '</td>' + 
				'</tr>');
	});
}


// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	return JSON.stringify({
		"projectName": $('#projectName').val(), 
		"description": $('#description').val(),
		"budget": $('#budget').val(),
		"endingDate": $('#endingDate').val(),
		"ownerName": $('#ownerName').val(),
		"assigneeName": $('#assigneeName').val()
		});
}
