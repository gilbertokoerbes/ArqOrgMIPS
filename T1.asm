# int BinSearch(const int A[], int Prim, int Ult, int Valor)
# // ---------------------------------------------------------
#// Dado um vetor A, pesquisa entre elementos A[Prim] 
#// at� A[Ult] por Valor, usando pesquisa bin�ria.
#//
#// Pr�-condi��es: 0<=Prim, Ult<=Tam-1, onde Tam � o tamanho
#// m�ximo do Vetor A e A[Prim]<=A[Prim+1]<=...<=A[Ult], 
#// ou seja, o vetor est� ordenado em ordem crescente.
#//
#// P�s-condi��o: Se Valor existe no vetor A, retorna
#// o �ndice do vetor igual a Valor, sen�o retorna -1.
#// ---------------------------------------------------------
#{
# if (Prim > Ult)
# return -1; // Valor n�o existe
# else
# { // Invariante: Se Valor existe em A, 
# // A[Prim]<=Valor<=A[Ult]
# int Meio = (Prim + Ult)/2;
# if (Valor == A[Meio])
# return Meio; // Encontrou Valor em A[Meio]
# else if (Valor<A[Meio])
# return BinSearch(A, Prim, Meio-1, Valor);
#// Recurs�o na metade inferior do vetor
# else
# return BinSearch(A, Meio+1, Ult, Valor);
#// Recurs�o na metade superior do vetor
# } // end else
#} // end BinSearch

.data
A: .word -0x5 -0x1 0x5 0x9 0x12 0x15 0x21 0x29 0x31 0x58 0x250 0x325	#Valores do array
prim: .word 0								#Aponta para a primeira posi��o do array (a[0])
ult: .word 0								#Aponta para a ultima posi��o do array (a[length-1])
rtnPosicao: .word 0								#Retorna o �ndice do valor correspondente
meio: .word 0								
size: .word 12								#Tamanho/Numero de itens do array
	
	
	.text
	.globl main

main:	
#	##Carregando o Array A na pilha
#	la $t0, A 		#Carrega o endereco do vetor A		
#	lw $t1, size		#le o tamanho do array indicado	
#	mul $t2, $t1, -4 	#multiplica o tamanho indicado por -4(espa�o por valor)
#	move $t3, $zero		#contador up
#
#	
#	loop1:
#	ble $t3, $t2, next 	#contador Down � menor que as posicoes alocadas em pilha(-48)? sim -> label
#	
#	add $sp, $sp, -4	#Cria espa�o na pilha
#	lw $t4, 0($t0) 		#carrega o valor obtido do endere�o/indice A
#	sw $t4, 0($sp)		#carrega o valor na pilha
#	addi $t0, $t0, 4 	#incrementa um indice da posicao de memoria do array A
#	
#	addi $t3, $t3, -4 	#descrementa -4 em rela��o ao anterior. Ex: 0 - 4 -> -4
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
	
	
	
	
	
	
	
	
	  
	
	
	
	
		
	

	