# Crud-Tarefas_Springboot
#ADICIONAR NOVA TAREFA
http://localhost:8080/tarefas
{
    "titulo": "Título 15",
    "descricao": "Descrição da Tarefa",
    "status": "ABERTA"
}
#EDITAR TAREFA
http://localhost:8080/tarefas/1
{
    "titulo": "Título da Editada",
    "descricao": "Descrição da Tarefa",
    "status": "CONCLUIDA"
    #STATUS PODE SER: ABERTA, EM_ANDAMENTO E CONCLUIDA
}
#EXCLUIR TAREFA
http://localhost:8080/tarefas/1
#LISTAR TAREFAS
http://localhost:8080/tarefas

LEMBRANDO QUE PARA CONSULTAR POR UM FRONT TEM QUE PASSAR A ORIGEM NO ARQUIVO WebConfig:
.allowedOrigins("http://localhost:5173") // Altere para o endereço do seu frontend
