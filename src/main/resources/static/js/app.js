/**
 * Created by campitos on 26/07/15.
 */
var aplicacionsita=angular.module('appita',['ngResource']);
aplicacionsita.controller('control1',function($scope,$http,$resource){
    $scope.mensaje='bienvenido a angular js';



    //
    var Usuario=$resource('http://192.168.1.69:8080/usuario:id', {id:'@id'},
        { creadito: { method: "POST" }, salvate: { method: "PUT" }, borrar:{method:"DELETE"}});

    //Hacemos un query de todos
    $scope.usuarios=Usuario.query(function(){
        var tama=$scope.usuarios.length;

        console.log("tamano:"+tama);
        var primero= $scope.usuarios[0];
        console.log(primero.nombre+" "+primero.sueldo+" "+primero.edad);
    });


    $scope.conectarse=function(){
        console.log("antes de conectarse");
        var Usuario=$resource('http://192.168.1.69:8080/usuario:id', {id:'@id'},
            { creadito: { method: "POST" }, salvate: { method: "PUT" }, borrar:{method:"DELETE"}});

        //Hacemos un query de todos
        $scope.usuarios=Usuario.query(function(){
            var tama=$scope.usuarios.length;

            console.log("tamano:"+tama);
           var primero= $scope.usuarios[0];
            console.log(primero.nombre+" "+primero.sueldo+" "+primero.edad);
        });

    };
});