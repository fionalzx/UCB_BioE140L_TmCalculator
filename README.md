# UCB_BioE140L_TmCalculator
### Zixin Fiona Lin

## Methodology

This version of Tm Calculator is developed based on the nearest neighbor method for thermodynamic calculations. The main equation used is based on Equation 3 in SantaLucia, J Jr.(1998). 

- Tm = ΔH°/(ΔS°+RlnCT)

ΔH° denotes for the prediction of enthaply during the process and ΔS° denotes for the prediction of entropy. Use the unified NN parameters and method in Equation 1 in SantaLucia, J Jr.(1998), we can calculate the prediction of enthaply and entropy after identifying all the possible Watson–Crick NNs in our sequence.

CT denotes for the total oligonucleotide strand concentration: 
- CT = [DNA·primer]/([DNA])([primer]).
- Assuming there are excessive primers: CT ≈ 1/[primer].

Finally, we can apply salt adjustion to Tm for Na+ concentration based on Nakano et al.(1999).

Therefore, we get the formula for Tm in K: 
- Tm = ΔH° / (ΔS° + Rln(1/[primer])) + 16.6*log([Na+]).
- To convert Tm in K to °C, we just need to subtract 273.15 from Tm in K.

## Assumptions

1) The annealing occurs at pH 7.0.
2) Default [Na+] = 50mM
3) Default [primer] = 200nM

## Reference

SantaLucia, J Jr. “A unified view of polymer, dumbbell, and oligonucleotide DNA nearest-neighbor thermodynamics.” Proceedings of the National Academy of Sciences of the United States of America vol. 95,4 (1998): 1460-5. doi:10.1073/pnas.95.4.1460

Nakano, S et al. “Nucleic acid duplex stability: influence of base composition on cation effects.” Nucleic acids research vol. 27,14 (1999): 2957-65. doi:10.1093/nar/27.14.2957
