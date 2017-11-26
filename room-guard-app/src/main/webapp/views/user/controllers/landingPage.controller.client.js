(function() {

    angular
        .module("RoomGuardWebApp")
        .controller("LandingPageController",LandingPageController);

    function LandingPageController ($location,$routeParams ,$timeout ) {
        var vm = this;

        function init() {

            console.log("landing Page init called...");

        }
        init();
    }
})();