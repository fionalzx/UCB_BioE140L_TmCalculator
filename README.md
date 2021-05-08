# UCB_BioE140L_TmCalculator
## Zixin Fiona Lin

## Methodology

This version of Tm Calculator is developed based on the nearest neighbor method for thermodynamic calculations. The main equation used is based on Equation 3 in SantaLucia, J Jr.(1998)PNAS, 95:1460-5. 

Tm = ΔH°/(ΔS°+RlnCT)
CT denotes for the total oligonucleotide strand concentration

We then apply salt adjustion to Tm for Na+ concentration based on Nakano et al.(1999).

Therefore, we get the formula for Tm in K:
Tm = (abs(ΔH°) - 3.4kcal/mol) / (abs(ΔS°) + Rln(1/[primer]) + 16.6*log([Na+])
To convert Tm in K to °C, we can just subtract 273.15 from Tm in K.

## Assumptions

1) The annealing occurs at pH 7.0.
2) Default [Na+] = 50mM
3) Default [primer] = 200nM

## Reference

SantaLucia, J Jr. “A unified view of polymer, dumbbell, and oligonucleotide DNA nearest-neighbor thermodynamics.” Proceedings of the National Academy of Sciences of the United States of America vol. 95,4 (1998): 1460-5. doi:10.1073/pnas.95.4.1460

Sugimoto, N et al. “Improved thermodynamic parameters and helix initiation factor to predict stability of DNA duplexes.” Nucleic acids research vol. 24,22 (1996): 4501-5. doi:10.1093/nar/24.22.4501

Nakano, S et al. “Nucleic acid duplex stability: influence of base composition on cation effects.” Nucleic acids research vol. 27,14 (1999): 2957-65. doi:10.1093/nar/27.14.2957
