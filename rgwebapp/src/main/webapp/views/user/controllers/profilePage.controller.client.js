(function() {

    angular
        .module("RoomGuardWebApp")
        .controller("ProfilePageController",ProfilePageController);

    function ProfilePageController ($location, $routeParams, $timeout, UserService) {
        var vm = this,
            id = $routeParams.UID;
        var init = function () {
          getUserById(id);
        };
        
        function getUserById(id) {
            var promise = UserService.getUserById(id);
            promise.then(function (response) {
                vm.user = response.data;
            },function (error) {
                console.log(error);
            })
        };
        
        init();
    }

})();