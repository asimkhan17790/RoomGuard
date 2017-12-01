(function() {

    angular
        .module("RoomGuardWebApp")
        .controller("LandingPageController",LandingPageController);

    function LandingPageController ($location, $routeParams, $timeout, UserService) {
        // By default we will be handling all the promise using than
        var vm = this;
        vm.user = {};
        vm.createUser = createUser;
        vm.loginPage = function() {
         };

        function createUser () {
            var promise = UserService.createUser(vm.user);
            promise.then(function (response) {
                console.log(response);
            },function (error) {
                console.log(error);
            })
        }
    }
})();