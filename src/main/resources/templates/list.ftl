<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Person </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	        
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="uname">Name</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.user.name" id="uname" class="username form-control input-sm" placeholder="Enter person name (Mark, Jonathan etc)" required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="Search" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                        <button type="button" ng-click="ctrl.initial()" class="btn btn-warning btn-sm">Initial</button>
	                        <button type="button" ng-click="ctrl.assign()" class="btn btn-warning btn-sm">Assign</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    
    
    
    
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Projects </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>Project Name</th>
		                <th>Description</th>
		                <th>Budget</th>
		                <th>Ending Date</th>
		                <th>Owner Name</th>
		                <th>Assignee Name</th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="p in ctrl.getProjectByName().projects">
		                <td>{{p.projectName}}</td>
		                <td>{{p.description}}</td>
		                <td>{{p.budget}}</td>
		                <td>{{p.endingDate}}</td>
		                <td>{{p.ownerName}}</td>
		                <td>{{p.assigneeName}}</td>
		            </tr>

		            </tbody>
		        </table>
		        		        										
			</div>
		</div>
    </div>
    
    
    
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Bids </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>Project Name</th>
		                <th>Engineer Name</th>
		                <th>Proposal</th>
		                <th>Amount</th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="b in ctrl.getBidByEngineerName().bids">
		                <td>{{b.projectName}}</td>
		                <td>{{b.engineerName}}</td>
		                <td>{{b.proposal}}</td>
		                <td>{{b.amount}}</td>
		            </tr>

		            </tbody>
		        </table>				        						
		        										
			</div>
		</div>
    </div>
       
    
</div>