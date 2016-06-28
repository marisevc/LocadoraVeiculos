var app = angular.module('ModuloLocadora',[]);

app.controller('locadoraControl', function($scope, $http){	
	var url = 'http://localhost:8080/LocadoraVeiculos/rs/cliente';
		
	$scope.salvar = function(){
		$http.post(url,$scope.cliente).success(function (locadoraRetorno){
			$scope.clientes.push(locadoraRetorno);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);
		});		
	}
	
	$scope.excluir = function(){
		$http.delete(url + "/" + $scope.cliente.codigo).success(function(){
			$scope.clientes.splice($scope.clientes.indexOf($scope.cliente),1);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);
		});		
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (locadoraRetorno){
			$scope.clientes = locadoraRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro);
		});
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.cliente = "";
	}	
	
	$scope.seleciona = function(locadoraTabela){
		$scope.cliente = locadoraTabela;
	}
		
	$scope.pesquisar = function(){
		
	}
	
});