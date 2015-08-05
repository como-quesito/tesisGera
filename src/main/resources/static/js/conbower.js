/**
 * Created by campitos on 28/07/15.
 */
var aplicacion=angular.module('apita',[]);
aplicacion.controller('con1',function($scope,$http){
    $scope.mensaje="Hola desde bower";
    $http.get('http://localhost:8080/usuario').success(function(datos){
        $scope.usuarios=datos;
        console.log(datos.length);
        console.log(datos[0].nombre);
        console.log(datos[0].edad);
        console.log(datos[0].sueldo);
    });
});