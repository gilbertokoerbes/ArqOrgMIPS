##Authores: Arthur_Gil(20101221) Gilberto_Koerbes(20204011)##

.data
A: .word -0x5 -0x1 0x5 0x9 0x12 0x15 0x21 0x29 0x31 0x58 0x250 0x325	#Valores do array
prim: .word 0								#Aponta para a primeira posição do array (a[0])
ult: .word 0								#Retorna o índice do valor correspondente
meio: .word 0								
size: .word 12								#Tamanho/Numero de itens do array
msgSaida: .asciiz "\n\n Valor para primeira busca = "	
	
	.text
	.globl main

main:	
	# passagem de paremetros
	move $s2,$zero
	addi $sp, $sp, -16 #abre espaço memória
	inicio:
	srl $t0,$t1,5
	beq $s2,0 label0
	beq $s2,1 label1
	beq $s2,2 label2
	beq $s2,3 label3
	bgt $s2,3 encerra	
			
					
	label0:
	li $a0, 0  #Indice Inicio
	li $a1, 11 #Indice Fim
	li $a3, 0x325 #Valor procurado
	j carregaPilha
	
	label1:
	li $a0, 11  #Indice Inicio
	li $a1, 11 #Indice Fim
	li $a3, -0x01 #Valor procurado
	j carregaPilha
	
	label2:
	li $a0, 0  #Indice Inicio
	li $a1, 5 #Indice Fim
	li $a3, -0x01 #Valor procurado
	j carregaPilha
	
	label3:
	li $a0, 4  #Indice Inicio
	li $a1, 11 #Indice Fim
	li $a3, 0x31 #Valor procurado
	j carregaPilha
	
	carregaPilha:
	la $t0, A 
	sw $t0, 12($sp) #carrega o endereco do array
	sw $a0, 8($sp) #carrega o primeiro indice procurado
	sw $a1, 4($sp) # carrega o valor do ultimo indice procurado
	sw $a3, 0($sp) # valor procuado
	j binSearch
	
	nextBin: #volta aqui apos executar binSearch
	
	move $s0, $v0 #guardar o valor encontrado	
	la $a0, msgSaida  #exibir mensagem
	li  $v0, 4
        syscall			
	
	li  $v0, 1           
    	move $a0, $s0 
        syscall
    	
    	addiu $s2, $s2, 1
    	j inicio
	
	#parar a execucao
	encerra:
	addi $sp, $sp, 16 #limpa memória	
	li  $v0, 10           
    	syscall
	
	
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
	#li $t7, 2
	div $t3, $t2, 2  # divide por dois para encontrar o Indice[meio]
	mul $t6, $t3, 4 #multiplica o indice pelo tamanho de 4
	lw  $t4, A($t6) #lê o valor[i(meio)] do array e armazena
	lw $t5, 0($sp) #le o valor na base da pilha (valor procurado)
	
	#if
	beq $t5, $t4, igualMeio
	j elseIf 	#caso nao seja igual meio, pular para else if
		igualMeio:
			move $v0, $t3 #retorna a posição encontrada
			j nextBin	
	elseIf:
		blt $t5, $t4, menorMeio
		j maiorMeio
		
		menorMeio:
			
			sw $t8, 12($sp) 	#posicao do array A
			sw $t0, 8($sp) 		# valores Prim
			addi $t3, $t3, -1	#atualizando o valor Ult
			sw $t3, 4($sp)		#valor Ult[meio -1]
			sw $t9, 0($sp)		#valor procurado
			j binSearch
		
		maiorMeio:
		
			sw $t8, 12($sp) 	#posicao do array A
			addi $t3, $t3, 1	#atualizando o valor Ult
			sw $t3, 8($sp) 		# valores Prim
			sw $t1, 4($sp)		#valor Ult[meio -1]
			sw $t9, 0($sp)		#valor procurado
			j binSearch	
			
	
	
	
	
	
	
	
	
	
	
	
	
	  
	
	
	
	
		
	

	
