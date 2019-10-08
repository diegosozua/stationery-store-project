/**
 * Author: Diego S. Costa
 */
app.controller("StationeryController", ['$scope', 'StationeryService', function($scope, StationeryService) {

    $scope.stationeries = [];
    $scope.stationeryForm = {
        barcode: "",
        name: "",
        description: "",
        quantity: 0,
        category: ""
    };

    getAllStationeryProducts();

    function getAllStationeryProducts() {
        StationeryService.getAllStationeryProducts()
            .then(function success(response) {
                $scope.stationeries = response.data;
            },
            function error (response) {
                $scope.errorMessage = "Error: " + response.status + ":" + response.data;
            });
    }

    $scope.createStationeryProduct = function () {
        if($scope.stationeryForm != null && $scope.stationeryForm.name) {
        StationeryService.createStationeryProduct($scope.stationeryForm)
           .then(function success(response) {
                $scope.message = "Product added!";
                $scope.errorMessage = '';
                productSuccess(response);
           },
           function error(response) {
                $scope.errorMessage = 'Error adding product!';
                $scope.message = '';
           });
        } else {
            $scope.errorMessage = 'Please enter a product!';
            $scope.message = '';
        }
    }

    $scope.updateStationeryProduct = function (stationery) {
        if(editStationeryProduct(stationery) != null && stationery.id != -1) {
        StationeryService.updateStationeryProduct(stationery)
            .then(function success(response) {
                $scope.message = "Product updated!";
                $scope.errorMessage = '';
                productSuccess(response);
           },
           function error(response) {
                $scope.errorMessage = 'Error updating product!';
                $scope.message = '';
           });
        } else {
            $scope.errorMessage = 'Please enter a product!';
            $scope.message = '';
        }
    }

    $scope.deleteStationeryProduct = function (stationery) {
        StationeryService.deleteStationeryProduct(stationery.id)
            .then (function success(response) {
                $scope.message = 'Product deleted!';
                $scope.stationeryForm = null;
                $scope.errorMessage = '';
                productSuccess(response);
            },
            function error (response) {
                $scope.errorMessage = 'Error deleting product!';
                $scope.message = '';
            });
    }

    $scope.editStationeryProduct = function(stationery) {
        $scope.stationeryForm.barcode = stationery.barcode;
        $scope.stationeryForm.name = stationery.name;
        $scope.stationeryForm.description = stationery.description;
        $scope.stationeryForm.quantity = stationery.quantity;
        $scope.stationeryForm.category = stationery.category;
    }

    function clearFormFields() {
        $scope.stationeryForm.barcode = "";
        $scope.stationeryForm.name = "";
        $scope.stationeryForm.description = "";
        $scope.stationeryForm.quantity = 0;
        $scope.stationeryForm.category = "";
    }

    function productSuccess(response) {
        getAllStationeryProducts();
        clearFormFields();
    }

}]);
