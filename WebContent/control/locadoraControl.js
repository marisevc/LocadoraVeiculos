var app = angular.module('ModuloLocadora',[]);

app.controller('locadoraControl', function($scope, $http){	
	var url = 'http://localhost:8080/LocadoraVeiculos/rs/cliente';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (locadoraRetorno){
			$scope.clientes = locadoraRetorno;
		}).error(function(mensagemErro){
			$scope.mensagens.push('Erro ao pesquisar clientes: '+mensagemErro);
		});
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
		
	$scope.salvar = function(){
		$http.post(url,$scope.cliente).success(function (locadoraRetorno){
			$scope.clientes.push(locadoraRetorno);
			$scope.novo();
			$scope.mensagens.push('Cliente salvo com sucesso');
		}).error(function(mensagemErro){
			$scope.montaMensagemErro(erro.parameterViolations);
		});
	}
	
	$scope.atualizar = function(){
		$http.put(url + "/" + $scope.cliente.codigo).success(function(){
			$scope.clientes.splice($scope.clientes.indexOf($scope.cliente),1);
			$scope.novo();
			$scope.mensagens.push('Cliente atualizado com sucesso');
		}).error(function(mensagemErro){
			$scope.montaMensagemErro(erro.parameterViolations);
		});		
	}
	
	$scope.excluir = function(){
		if ($scope.cliente.codigo == '') {
			alert('Selecione um cliente');
		} else {
		$http.delete(url + "/" + $scope.cliente.codigo).success(function(){
			$scope.clientes.splice($scope.clientes.indexOf($scope.cliente),1);
			$scope.pesquisar();
			$scope.novo();
			$scope.mensagens.push('Cliente excluido com sucesso');
		}).error(function(mensagemErro){
			$scope.mensagens.push('erro ao excluir cliente: '+erro);
		});	
		}
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