la $t0, X # load the address of X into $t0
and $s1, $s1, $zero # clear $s1 aka temp sum
add $s1, $s1, $t1 # add it to the running sum
addi $t0, $t0, 4 # increment to the next address
addi $s0, $s0, -1 # decrement the loop counter
bne $0, $s0, loop # loop back until complete
sw $s1, SUM # store the final total
