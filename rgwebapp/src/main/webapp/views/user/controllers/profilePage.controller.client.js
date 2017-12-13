(function() {

    angular
        .module("RoomGuardWebApp")
        .controller("ProfilePageController",ProfilePageController);

    function ProfilePageController ($location, $routeParams, $timeout, UserService, Upload) {
        var vm = this,
            email = $routeParams.UID;
       vm.uploadImage =  function () {
           Upload.upload({
               url: 'http://localhost:8080/roomGuardWebApp/rest/detail',
               fields: {'emailAddress': 'sumit.pec001@gmail.com'}, // additional data to send
               file: vm.file
           }).then(function (data) {
           var image = data.data.image;
           vm.imageURL = 'data:image/jpeg;base64,' + image;
       })
       };

        var init = function () {
            getUserByEmail(email);
        };
        
        function getUserByEmail(email) {
            var promise = UserService.getUserByEmail(email);
            promise.then(function (response) {
                vm.user = response.data;
            },function (error) {
                $location.url("/");
                console.log(error);
            })
        };
        
        init();
    }

})();