(function() {

    angular
        .module("RoomGuardWebApp")
        .controller("ProfilePageController",ProfilePageController);

    function ProfilePageController ($location, $routeParams, $timeout, UserService, Upload) {
        var vm = this,
            id = $routeParams.UID;
       vm.uploadImage =  function () {
           Upload.upload({
               url: 'http://localhost:8080/roomGuardWebApp/rest/detail',
               fields: {'emailAddress': 'sumit.pec001@gmail.com'}, // additional data to send
               file: vm.file
           }).then(function (data) {
           vm.image = data.data.image;
       })
       };

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