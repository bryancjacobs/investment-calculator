
var app = angular.module('main', ['ngTable']);

app.controller('DemoCtrl', function($scope, $filter, ngTableParams) {
    var data =[
        {
            "name": "FSELX",
            "quotes": [
                {
                    "adjusted": 71.34,
                    "change": -3.0698065601346,
                    "date": 1397023200000
                },
                {
                    "adjusted": 69.15,
                    "change": 2.0245842371656,
                    "date": 1397628000000
                },
                {
                    "adjusted": 70.55,
                    "change": -1.3607370659107,
                    "date": 1398232800000
                },
                {
                    "adjusted": 69.59,
                    "change": -0.80471332087944,
                    "date": 1398837600000
                },
                {
                    "adjusted": 69.03,
                    "change": 0.46356656526147,
                    "date": 1399442400000
                },
                {
                    "adjusted": 69.35,
                    "change": 1.3842826243692,
                    "date": 1400047200000
                },
                {
                    "adjusted": 70.31,
                    "change": 3.3992319726924,
                    "date": 1400652000000
                },
                {
                    "adjusted": 72.7,
                    "change": 2.1870701513067,
                    "date": 1401256800000
                },
                {
                    "adjusted": 74.29,
                    "change": 3.0555929465608,
                    "date": 1401861600000
                },
                {
                    "adjusted": 76.56,
                    "change": 1.5673981191223,
                    "date": 1402466400000
                },
                {
                    "adjusted": 77.76,
                    "change": -0.41152263374487,
                    "date": 1403071200000
                },
                {
                    "adjusted": 77.44,
                    "change": 1.6787190082645,
                    "date": 1403676000000
                },
                {
                    "adjusted": 78.74,
                    "change": null,
                    "date": 1404280800000
                }
            ]
        },
        {
            "name": "YHOO",
            "quotes": [
                {
                    "adjusted": 34.87,
                    "change": 4.2443361055349,
                    "date": 1397023200000
                },
                {
                    "adjusted": 36.35,
                    "change": -2.5034387895461,
                    "date": 1397628000000
                },
                {
                    "adjusted": 35.44,
                    "change": 1.4390519187359,
                    "date": 1398232800000
                },
                {
                    "adjusted": 35.95,
                    "change": -5.2294853963839,
                    "date": 1398837600000
                },
                {
                    "adjusted": 34.07,
                    "change": 0.29351335485765,
                    "date": 1399442400000
                },
                {
                    "adjusted": 34.17,
                    "change": 0.55604331284752,
                    "date": 1400047200000
                },
                {
                    "adjusted": 34.36,
                    "change": 1.2223515715949,
                    "date": 1400652000000
                },
                {
                    "adjusted": 34.78,
                    "change": -0.14376078205867,
                    "date": 1401256800000
                },
                {
                    "adjusted": 34.73,
                    "change": 5.4707745465016,
                    "date": 1401861600000
                },
                {
                    "adjusted": 36.63,
                    "change": -4.6137046137046,
                    "date": 1402466400000
                },
                {
                    "adjusted": 34.94,
                    "change": -4.8368631940469,
                    "date": 1403071200000
                },
                {
                    "adjusted": 33.25,
                    "change": 7.9097744360902,
                    "date": 1403676000000
                },
                {
                    "adjusted": 35.88,
                    "change": null,
                    "date": 1404280800000
                }
            ]
        }
    ];

//    var data = [{name: "Moroni", age: 50},
//        {name: "Tiancum", age: 43},
//        {name: "Jacob", age: 27},
//        {name: "Nephi", age: 29},
//        {name: "Enos", age: 34},
//        {name: "Tiancum", age: 43},
//        {name: "Jacob", age: 27},
//        {name: "Nephi", age: 29},
//        {name: "Enos", age: 34},
//        {name: "Tiancum", age: 43},
//        {name: "Jacob", age: 27},
//        {name: "Nephi", age: 29},
//        {name: "Enos", age: 34},
//        {name: "Tiancum", age: 43},
//        {name: "Jacob", age: 27},
//        {name: "Nephi", age: 29},
//        {name: "Enos", age: 34}];

    $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: 100,          // count per page
            sorting: {
                name: 'asc'     // initial sorting

            }
        },
        {
        total: data.length, // length of data
        getData: function($defer, params) {
            // use build-in angular filter
            var orderedData = params.sorting() ?
                $filter('orderBy')(data, params.orderBy()) :
                data;

            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
        }
    });
});