.text
.globl main
main:         j label0
        jr $ra
        add $t0, $t1, $t2
        lw $t0, 0($t1)
        beq $t0, $t1, main 
        bne $t1, $s2, main 
        ori $t1, $t1, 2
        and $t0, $t1, $t2
        label0: srl $t1, $t2, 1
        slti $t0, $t1, 10
