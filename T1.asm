# int BinSearch(const int A[], int Prim, int Ult, int Valor)
# // ---------------------------------------------------------
#// Dado um vetor A, pesquisa entre elementos A[Prim] 
#// até A[Ult] por Valor, usando pesquisa binária.
#//
#// Pré-condições: 0<=Prim, Ult<=Tam-1, onde Tam é o tamanho
#// máximo do Vetor A e A[Prim]<=A[Prim+1]<=...<=A[Ult], 
#// ou seja, o vetor está ordenado em ordem crescente.
#//
#// Pós-condição: Se Valor existe no vetor A, retorna
#// o índice do vetor igual a Valor, senão retorna -1.
#// ---------------------------------------------------------
#{
# if (Prim > Ult)
# return -1; // Valor não existe
# else
# { // Invariante: Se Valor existe em A, 
# // A[Prim]<=Valor<=A[Ult]
# int Meio = (Prim + Ult)/2;
# if (Valor == A[Meio])
# return Meio; // Encontrou Valor em A[Meio]
# else if (Valor<A[Meio])
# return BinSearch(A, Prim, Meio-1, Valor);
#// Recursão na metade inferior do vetor
# else
# return BinSearch(A, Meio+1, Ult, Valor);
#// Recursão na metade superior do vetor
# } // end else
#} // end BinSearch

.data
A: .word -0x5 -0x1 0x5 0x9 0x12 0x15 0x21 0x29 0x31 0x58 0x250 0x325	#Valores do array
prim: .word 0								#Aponta para a primeira posição do array (a[0])
ult: .word 0								#Aponta para a ultima posição do array (a[length-1])
rtnPosicao: .word 0								#Retorna o índice do valor correspondente
meio: .word 0								
size: .word 12								#Tamanho/Numero de itens do array
	
	
	.text
	.globl main

main:	
#	##Carregando o Array A na pilha
#	la $t0, A 		#Carrega o endereco do vetor A		
#	lw $t1, size		#le o tamanho do array indicado	
#	mul $t2, $t1, -4 	#multiplica o tamanho indicado por -4(espaço por valor)
#	move $t3, $zero		#contador up
#
#	
#	loop1:
#	ble $t3, $t2, next 	#contador Down é menor que as posicoes alocadas em pilha(-48)? sim -> label
#	
#	add $sp, $sp, -4	#Cria espaço na pilha
#	lw $t4, 0($t0) 		#carrega o valor obtido do endereço/indice A
#	sw $t4, 0($sp)		#carrega o valor na pilha
#	addi $t0, $t0, 4 	#incrementa um indice da posicao de memoria do array A
#	
#	addi $t3, $t3, -4 	#descrementa -4 em relação ao anterior. Ex: 0 - 4 -> -4
#	j loop1
#		
#	#continua execucao
#	next:
	
	# passagem de paremetros
	
	la $s0, A
	la $a0, ($s0)
	li $a1, 0 #valor do primeiro indice de busca
	li $a2, 11 #le o valor do ultimo indice de busca
	li $a3, 5 #valor a ser procurado
	j binSearch
	nextBin:
	#syscall etc..	
	
	binSearch:
	
	bgt $a1, $a2, rtn1 #if (Prim > Ult)
	j else
	rtn1:
		li $v0, -1
	j nextBin
	
	#else
	else:	
	add $t1, $a1, $a2 #soma primeiro e ultimo indice solicitado
	srl $t2, $t1, 2	  #divide por 2 a soma
	
	move $t4, $zero #contador	
	loopMeio: #procura se o valor esta no meio
	
	
	
	
	
	
	
	
	  
	
	
	
	
		
	

	