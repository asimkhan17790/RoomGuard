(function() {

    angular
        .module("RoomGuardWebApp")
        .controller("LandingPageController",LandingPageController);

    function LandingPageController ($http,$location, $routeParams, $timeout, UserService) {
        // By default we will be handling all the promise using than
        var vm = this;
        vm.user = {};
        vm.createUser = createUser;
        vm.login = function() {
            var promise = UserService.findUserByCredentials(vm.user.emailAddress, vm.user.password);
            promise.then(function (response) {
                 $http.defaults.headers.common['Authorization'] = 'Bearer ' + response.data.token;
                closeModal();
                // TODO getting the UserId from the response
                $timeout(function () {
                    $location.url("/user/profilePage/"+ response.data.id);
                }, 350);
            },function (error) {
                console.log(error);
            })
         };

        function createUser () {
            var promise = UserService.createUser(vm.user);
            promise.then(function (response) {
                closeModal();
                // TODO getting the UserId from the response
                $timeout(function () {
                        $location.url("/user/profilePage/"+ response.data.id);
                }, 350);
            },function (error) {
                console.log(error);
            })
        };

        // Function for closing the modal
        function closeModal() {
            $('.modal').modal('hide');
        }
    }
})();