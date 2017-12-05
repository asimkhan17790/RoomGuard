(function() {

    angular
        .module("RoomGuardWebApp")
        .config(configuration);
    function configuration($routeProvider,$httpProvider,$compileProvider) {
        $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|file|ftp|blob):|data:image\//);
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
                templateUrl:"./views/user/templates/landingPage.view.client.html",
                controller:"LandingPageController",
                controllerAs:"model",
                data: {
                    pageTitle: 'Room Guard'
                }
            })
            .when("/user/profilePage/:UID", {
                templateUrl:"./views/user/templates/profilePage.view.client.html",
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