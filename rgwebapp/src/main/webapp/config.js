(function() {
    // maybe format it alter on as declaring the function doesn't
    // look nice
    angular
        .module("RoomGuardWebApp")
        .factory('authInterceptor' , function ($q, $window) {
            return {
                request: function (config) {
                    config.headers = config.headers || {};
                    if ($window.sessionStorage.token) {
                        config.headers.Authorization = 'Bearer ' + $window.sessionStorage.token;
                    }
                    return config;
                },
                responseError: function (rejection) {
                    if (rejection.status === 401) {
                        // handle the case where the user is not authenticated
                    }
                    return $q.reject(rejection);
                }
            };
        })
        .config(configuration);

    function configuration($routeProvider,$httpProvider,$compileProvider) {
        $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|file|ftp|blob):|data:image\//);
        $httpProvider.defaults.withCredentials = true;
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
        $httpProvider.defaults.headers.put['Content-Type'] = 'application/json;charset=utf-8';
        $httpProvider.interceptors.push('authInterceptor');
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