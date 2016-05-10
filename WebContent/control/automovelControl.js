var app = angular.module('ModuloAutomovel',[]);
app.controller('automovelControl', function($scope, $http){
	
	var url = 'http://localhost:8080/LocadoraVeiculos/rs/automovel';	
	
	$scope.salvar = function(){
		$http.post(url,$scope.automovel).success(function (automovelRetorno){
			$scope.automoveis.push(automovelRetorno);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);
		});		
	}
	
	$scope.excluir = function(){
		$http.delete(url + "/" + $scope.automovel.codigo).success(function(){
			$scope.automoveis.splice($scope.automoveis.indexOf($scope.automovel),1);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);
		});		
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (automovelRetorno){
			$scope.automoveis = automovelRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro);
		});
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.automovel = "";
	}	
	
	$scope.seleciona = function(automovelTabela){
		$scope.automovel = automovelTabela;
	}
		
	$scope.pesquisar = function(){
		
	}
	
});