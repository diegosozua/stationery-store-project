/**
 * Author: Diego S. Costa
 */
app.service("StationeryService", ['$http', function($http) {
    this.getAllStationeryProducts = function getAllStationeryProducts() {
        return $http({
            method: 'GET',
            url: 'api/stationeries'
        });
    }

    this.createStationeryProduct = function createStationeryProduct(stationeries) {
        return $http({
            method: 'POST',
            url: 'api/stationeries',
            data: angular.toJson(stationeries),
            headers: {'Content-Type': 'application/json'}
        });
    }

    this.updateStationeryProduct = function updateStationeryProduct(stationeries) {
        return $http({
            method: 'PUT',
            url: 'api/stationeries',
            data: angular.toJson(stationeries),
            headers: {'Content-Type': 'application/json'}
        });
    }

    this.deleteStationeryProduct = function deleteStationeryProduct(id) {
        return $http({
            method: 'DELETE',
            url: 'api/stationeries/' + id
        });
    }

    this.getStationeryProductById = function getStationeryProductById(id) {
        return $http({
            method: 'GET',
            url: 'api/stationeries/' + id
        });
    }
}]);