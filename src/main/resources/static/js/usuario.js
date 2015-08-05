/**
 * Created by campitos on 30/07/15.
 */

var aplicacion=angular.module('apUsuario',['ngResource','ui.bootstrap']);
aplicacion.controller('ctrlUsuario',function($scope, $http,$resource,$modal,$log){

    var Usuario=$resource('/usuario/:id',{id:'@id'},{crear:{method:'POST'},
        actualizar:{method:'PUT'}, borrar:{method:'DELETE'}});

    //GET Todos
    $scope.buscarTodos=function(){
        $scope.usuarios= usuarios=Usuario.query(function(){
            console.log(usuarios.length);
        })
    }

    //Get por id
    $scope.buscarPorId=function(){

        $scope.usu=Usuario.get({id:1

        }, function(){
            console.log("Usuario ontenido:"+$scope.usu.nombre);
        });
    }


//UPDATE
    $scope.actualizarUsuario=function(){
        console.log("antes del evento update");
        var usuario = new Usuario();
        usuario.nombre = $scope.nombre;
        usuario.edad = $scope.edad;
        usuario.sueldo =$scope.sueldo;
        usuario.$actualizar(function (data) {
            console.log(data.nombre);
        });
    }

    //DELETE
    $scope.borrarUsuario=function(){
        var usuario=new Usuario();
        usuario.id=5;
        usuario.$borrar();
        console.log("si se borro");
    }

    //POST
    $scope.guardarUsuario=function() {

     console.log("antes del evento");
        var usuario = new Usuario();
        usuario.nombre = $scope.nombre;
        usuario.edad = $scope.edad;
        usuario.sueldo =$scope.sueldo;




        $scope.items = ['item1', 'item2', 'item3'];

        $scope.animationsEnabled = true;



        $scope.toggleAnimation = function () {
            $scope.animationsEnabled = !$scope.animationsEnabled;
        };
        usuario.$crear(function (data) {
            console.log(data.nombre);
        });
        console.log('se envia al oprimir el boton guardar de  esta pagina')



            var modalInstance = $modal.open({
                animation: $scope.animationsEnabled,
                templateUrl: 'myModalContent.html',
                controller: 'ModalInstanceCtrl',
                size: 'sm',
                resolve: {
                    items: function () {
                        return $scope.items;
                    }
                }
            });

            modalInstance.result.then(function (selectedItem) {
                $scope.selected = selectedItem;
            }, function () {
                $log.info('Modal dismissed at: ' + new Date());
            });


    };// Termina boton guardarUsuario()


});
// Please note that $modalInstance represents a modal window (instance) dependency.
// It is not the same as the $modal service used above.

angular.module('apUsuario').controller('ModalInstanceCtrl', function ($scope, $modalInstance, items) {

    $scope.items = items;
    $scope.selected = {
        item: $scope.items[0]
    };

    $scope.ok = function () {
        $modalInstance.close($scope.selected.item);
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});