var app = angular.module('ModuloLocacao',[]);
app.controller('locacaoControl', function($scope, $http){
	
	var url = 'http://localhost:8080/LocadoraVeiculos/rs/locacao';	
	
	$scope.salvar = function(){
		$http.post(url,$scope.locacao).success(function (locacaoRetorno){
			$scope.locacoes.push(locacaoRetorno);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);
		});		
	}
	
	$scope.excluir = function(){
		$http.delete(url + "/" + $scope.locacao.codigo).success(function(){
			$scope.locacoes.splice($scope.locacoes.indexOf($scope.locacao),1);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);
		});		
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (locacaoRetorno){
			$scope.locacoes = locacaoRetorno;
		}).error(function(mensagemErro){
			alert(mensagemErro);
		});
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.locacao = "";
	}	
	
	$scope.seleciona = function(locacaoTabela){
		$scope.locacao = locacaoTabela;
	}
		
	$scope.pesquisar = function(){
		
	}
	
});