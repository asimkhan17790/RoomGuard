(function() {

    angular
        .module("RoomGuardWebApp")
        .config(configuration);
    function configuration($routeProvider,$httpProvider) {
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
        $httpProvider.defaults.headers.put['Content-Type'] = 'application/json;charset=utf-8';
        $routeProvider
            .when("/", {
                templateUrl:"./views/user/templates/landingPage.view.client.html",
                controller:"LandingPageController",
                controllerAs:"model",
                data: {
                    pageTitle: 'Room Guard'
                }
            })
            .when("/landingPage", {
                templateUrl:"/views/user/templates/landingPage.view.client.html",
                controller:"LandingPageController",
                controllerAs:"model",
                data: {
                    pageTitle: 'Room Guard'
                }
            })
            .when("/user/profilePage", {
                templateUrl:"/views/user/templates/profilePage.view.client.html",
                controller:"ProfilePageController",
                controllerAs:"model",
                data: {
                    pageTitle: 'Profile Page'
                }
            }).otherwise({
            redirectTo:"/"
        });
    }


})();