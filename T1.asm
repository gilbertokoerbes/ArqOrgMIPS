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
#msgSaida: .	
	
	.text
	.globl main

main:	
#	##Carregando o Array A na pilha (DESNECESSARIO)
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
	li $a0, 0
	li $a1, 11
	li $a3, 9
	
	addi $sp, $sp, -16
	la $t0, A
	sw $t0, 12($sp)
	sw $a0, 8($sp)
	sw $a1, 4($sp)
	sw $a3, 0($sp)
	j binSearch
	nextBin:
	lw $s0, ($v0)
	
	
	
	binSearch:
	lw $t8, 12($sp) #valor do endereco do array A
	lw $t0,	8($sp)  # ler o valor do Prim
	lw $t1, 4($sp) # ler o valor do Ult
	lw $t9, 0($sp) #valor procurado
	bgt $t0, $t1, rtn1 #if (Prim > Ult)
	j else
	rtn1:
		li $v0, -1
	j nextBin
	
	
	#else
	else:
	add $t2, $t0, $t1 #soma prim e Ult
	srl $t3, $t2, 1 # divide por dois para encontrar o Indice[meio]
	mul $t6, $t3, 4 #multiplica o indice pelo tamanho de 4
	lw  $t4, A($t3) #lê o valor[i(meio)] do array e armazena
	lw $t5, 0($sp) #le o valor na base da pilha (valor procurado)
	
	#if
	beq $t5, $t4, igualMeio
	j elseIf 	#caso nao seja igual meio, pular para else if
		igualMeio:
			lw $v0, ($t3) #retorna a posição encontrada
			j nextBin	
	elseIf:
		blt $t5, $t4, menorMeio
		bgt $t5, $t4, maiorMeio
		
		menorMeio:
			addi $sp, $sp, -16 	#libera espaço na pilha
			
			sw $t8, 12($sp) 	#posicao do array A
			sw $t0, 8($sp) 		# valores Prim
			addi $t3, $t3, -1	#atualizando o valor Ult
			sw $t3, 4($sp)		#valor Ult[meio -1]
			sw $t9, 0($sp)		#valor procurado
			j binSearch
		
		maiorMeio:
			addi $sp, $sp, -16 	#libera espaço na pilha
			
			sw $t8, 12($sp) 	#posicao do array A
			addi $t3, $t3, 1	#atualizando o valor Ult
			sw $t3, 8($sp) 		# valores Prim
			sw $t1, 4($sp)		#valor Ult[meio -1]
			sw $t9, 0($sp)		#valor procurado
			j binSearch	
			
	
	
	
	
	
	
	
	
	
	
	
	
	  
	
	
	
	
		
	

	
