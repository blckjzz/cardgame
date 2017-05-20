# cardgame
O trabalho consiste no desenvolvimento de um jogo em Java que funciona da seguinte maneira: O jogo
começa com 10 jogadores sentados numa roda e um baralho no meio da roda contendo apenas as cartas 1, 3, 9 e 12
(que seria a Dama). Assuma um número ilimitado de cartas. A princípio o jogo segue no sentido horário e o primeiro
jogador (de número 1) começa o jogo tirando uma carta do baralho. Cada carta tem um significado, assim como
explicado abaixo:
1 – Pula o próximo jogador e passa a vez para o seguinte.
3 – Elimina o terceiro jogador contado a partir do jogador atual.
9 – Elimina o jogador anterior na roda.
12 – Inverte o sentido do jogo.
Depois que é executado o que a carta tirada pede, passa-se a vez para o próximo jogador, no sentido em que estiver
o jogo. O jogo termina quando só restar apenas 1 jogador.
A seguir é mostrado um exemplo com uma sequência de passos do jogo:
OBS: A carta que o jogador da rodada tira no baralho pode ser digitada pelo usuário ou selecionada
aleatoriamente no conjunto {1, 3, 9, 12}. Caso opte pela digitação, certifique-se que o usuário não forneça ao
programa um valor inválido
