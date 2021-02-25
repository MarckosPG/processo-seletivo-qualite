//base de dados das seções
data = [
    {
        id: 0,
        title: "Teste 1 ",
        subtitle: "Subtitle 1",
        quests: [
            {
                id: 0,
                by_id: 0,
                type: "text",
                maxlength: 100,
                quest: "Questao 1",
                required: true,
                response: "",
            },
            {
                id: 1,
                by_id: 0,
                type: "slide",
                quest: "Questao 2",
                response: "",
                first_option: "Opcao 1",
                second_option: "Opcao 2",
            },
            {
                id: 2,
                by_id: 0,
                type: "text",
                maxlength: 100,
                quest: "Questao 3",
                required: false,
                response: "",
            },
            {
                id: 3,
                by_id: 0,
                type: "text",
                maxlength: 25,
                quest: "Questao 4",
                required: true,
                response: "",
            },
        ]
    },
    {
        id: 1,
        title: "Teste 2",
        subtitle: "Subtitle 2",
        quests: [
            {
                id: 0,
                by_id: 1,
                type: "text",
                maxlength: 50,
                required: true,
                quest: "Questao 1",
                response: "",
            },
            {
                id: 1,
                by_id: 1,
                type: "slide",
                quest: "Questao 2",
                response: "",
                first_option: "Opcao 1",
                second_option: "Opcao 2",
            }
        ]
    },
    {
        id: 2,
        title: "Teste 3",
        subtitle: "Subtitle 3",
        quests: [
            {
                id: 0,
                by_id: 2,
                type: "text",
                maxlength: 100,
                 required: false,
                quest: "Questao 1",
                response: "",
            },
            {
                id: 1,
                by_id: 2,
                type: "slide",
                quest: "Questao 2",
                response: "",
                first_option: "Opcao 1",
                second_option: "Opcao 2",
            },
            {
                id: 2,
                by_id: 2,
                type: "text",
                maxlength: 255,
                required: false,
                quest: "Questao 3",
                response: "",
            },
        ]
    },
]

