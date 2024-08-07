# Flawless BackEnd

### Wedding Planner

- [x] CRUD CHECKLIST
- [x] CRUD CHECKLIST CATEGORY -> ADMIN
- [x] CRUD USUÁRIO
- [X] AUTENTICAÇÂO E AUTORIZAÇÃO
- [x] LISTAR TODOS OS CHECKLIST DE UM DETERMINADO USUÁRIO
- [x] CRUD BUDGET
- [x] ASSOCIAR O BUDGET AO USER
- [X] CRUD GUEST
- [x] CRUD TABLES
- [x] CRUD TABLES CATEGORY -> ADMIN
- [x] ASSOCIAR GUEST NAS TABLES
- [x] DEVE SER POSSÍVEL CADASTRAR GUEST SEM NECESSÁRIAMENTE ASSOCIALO A UMA TABLE
- [x] ASSOCIAR UM BUDGET AO USUÁRIO QUE O CRIOU
- [x] O USUÁRIO PODE CRIAR SUAS PRÓPRIAS CATEGORIAS
- [x] CADA USUÁRIO PODERÁ APENAS ACESSAR O SEU PERFIL
- [x] DATA DO CASAMENTO CRUD
- [x] ROTA PERFIL QUE TRARÁ SEMPRE O USUÁRIO LOGADO
- [ ] SEMPRE QUE SE CRIAR UM NOVO USUÁRIO EXECUTAR UM SEED DE CHECKLIST E MESA
- [ ] (findByUser)CADA USUÁRIO SÓ PODERÁ VER AS  CATEGORIAS DO SISTEMA, AS CATEGORIAS QUE ELE CRIOU, OS CHECKLIST QUE CRIOU/SYSTEMA, MESAS, GUEST E BUDGET
- [ ] (findByMesa) GUEST
- [ ] (findByCategoria) Mesa
- [ ] Refresh Token
- [ ] COLOCAR AS ANOTAÇÕES DE VALIDAÇÃO NECESSÁRIAS
- [ ] TESTAR OS TRY CATCH

### Comunicação Via Microserviço
- [ ] SEMPRE QUE O USUÁRIO CONTRATAR UM SERVIÇO O PREÇO DEVE REFLETIR NO BUDGET
- [ ] Deve ser possível o usuário trocar mensagens com o supplier [Ms chat]

# Erros
- [x] AO CRIAR USUÁRIO NÃO É POSSÍVEL LISTAR SE NÃO TIVER UM BUDGET ASSOCIADO
- [x] AO CRIAR O BUDGET ELE NÃO É AUTOMATICAMENTE ASSOCIADO OA USER QUE O CRIOU

### ECommerce

- [ ] CRUD SUPPLIER
- [ ] AUTENTICAÇÃO E AUTORIZAÇÂO
- [ ] DEVE SER POSSÍVEL O SUPPLIER FAZER O CRUD DOS PRODUTOS (DEVE ESTAR AUTENTICADO)
- [ ] O SUPPLIER PODE CRIAR AS SUAS PRÓPRIAS CATEGORIAS
- [ ] DEVE SER POSSÍVEL APLICAR DESCONTO NOS PRODUTOS (SUPPLIER + SYSTEM ADMIN)
- [ ] DEVE SER POSSÍVEL FAZER O CRUD UM DE COMBO DE PRODUTOS (SUPPLIER)
- [ ] DEVE SER POSSÍVEL FAZER UM COMBO DE PRODUTOS ENTRE SUPPLIERS PARCEIROS
