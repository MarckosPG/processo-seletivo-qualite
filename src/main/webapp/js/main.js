var index_ = 0; //variável inicializadora d ids dãs questões para fins de estilizações

data.map((item) => { 
   
    //listando as sessões
    $(".section-list").append(`
        <div class="section-item">
            <div class="section-header">
                <div class="section-title">${item.title}</div>
                <div class="section-subtitle">${item.subtitle}</div>
            </div>
            <div class="section-content">
                <div class="alert-error alert-id-${item.id}">Opa</div>
                <div class="quest-list ql${item.id}"></div>
            </div>
            <div class="section-footer">
               <button class="section-button send-ql-${item.id}">Enviar</button>
            </div>
        </div>
    `);
    
    //linkando evento do botão de enviar da seção
    $(".send-ql-"+item.id).click(function () {
        var q_obg = [];
        item.quests.map((quest) => { //adicionando de campos em branco
            if(quest.type == "text" && quest.required){
                if(quest.response == ""){
                    q_obg.push(quest);
                }
            }
        })
        if(q_obg.length > 0){ //verificando de campos em branco
            //console.log(q_obg);
            $(".alert-id-"+item.id).slideDown('fast');
            $(".alert-id-"+item.id).html("Preencha todos os campos obrigatorios!");
            setTimeout(function () {
                $(".alert-id-"+item.id).slideUp('fast');
            }, 3000)
            return;
        }else{
            console.log(item); // retornando um JSON da sessão
            $.post("Quests", {item : item}, function (response) {
                //alert(response)
                window.location = "viewquests.jsp";
            })
        }
    });
    
    item.quests.map((quest) => {
        //listando questões e seus respectivos tipos, com base global para implementar novos tipos
        if(quest.type == "text" && quest.by_id == item.id){
            $(".ql"+item.id).append(`
                <div class="quest-item qi-id-${quest.id} qq${index_}" quest-type="text">
                    <h4 class="quest-title" style="text-align: left;">${quest.quest} ${(quest.required) ? " *(obrigatorio)" : "(opcional)"}</h4>
                    <hr>
                    <textarea maxlength="${quest.maxlength}" type="text" id="text" data-item-required="${quest.required}" data-item-id="${index_}" class="quest-response-text ql-id-${quest.id}" placeholder="Resposta"></textarea>
                    <p style="margin:0; margin-right: 5px; width: 100%; text-align: right; color: gray;" class="counter${+index_}">${quest.maxlength}</p>
                </div>
            `);
        }else if (quest.type == "slide" && quest.by_id == item.id){
            quest.response = "50";
            $(".ql"+item.id).append(`
                <div class="quest-item" quest-type="slide">
                    <h4 class="quest-title" style="text-align: left;">${quest.quest}</h4>
                    <hr>
                    <p style="margin:0; width: 100%; text-align: left; color: gray;" class="vp${index_}">50%</p>
                    <input type="range" min="0" max="100" value="50" data-vp-id="${index_}" class="quest-response-slide ql-id-${quest.id} ">
                    <div class="row">
                        <label>${quest.first_option}</label>
                        <label>${quest.second_option}</label>
                    </div>
                </div>
            `);
        }
        
        index_++; //incrementando id global
        
        if(quest.type == "text"){ //funçao para atribuir valor das respostas dos usuários tipo texto
            $(".ql-id-"+quest.id).keyup(function () {
                quest.response = $(this).val();
            });
        }else if(quest.type == "slide"){ //funçao para atribuir valor das respostas dos usuários tipo slide
            $(".ql-id-"+quest.id).change(function () {
                quest.response = $(this).val();
            });
            $(document).on('input change', ".ql-id-"+quest.id, function() {
                id = $(this).attr("data-vp-id");
                $(".vp"+id).html($(this).val()+"%");
            });
        }
        
    })
    
});

$(".quest-response-text").focus(function () { //modificando status da questçao css 
    var dataItemId = $(this).attr("data-item-id");
    var dataRequired = $(this).attr("data-item-required");
    $(".qq"+dataItemId).css("background", "#dceafc");
})

$(".quest-response-text").focusout(function () { //modificando status da questçao css 
    var dataItemId = $(this).attr("data-item-id");
    var dataRequired = $(this).attr("data-item-required");
    if(isEmptyOrSpaces($(this).val())){
        if(dataRequired == "true"){
            $(".qq"+dataItemId).css("background", "#ffe0e1");
        }else{
            $(".qq"+dataItemId).css("background", "#fff");
        }
    }else{
        $(".qq"+dataItemId).css("background", "#ddfcdc");
    }
})

$(".quest-response-text").keyup(function () { //modificando status da questçao css 
    var maxlength = $(this).attr("maxlength");
    var dataItemId = $(this).attr("data-item-id");
    var dataRequired = $(this).attr("data-item-required");
    
    resto = parseInt(maxlength) - parseInt($(this).val().length);
    $(".counter"+dataItemId).text(resto);
    
    if(isEmptyOrSpaces($(this).val())){
        if(dataRequired == "true"){
            $(".qq"+dataItemId).css("background", "#ffe0e1");
        }else{
            $(".qq"+dataItemId).css("background", "#fff");
        }
    }else{
        $(".qq"+dataItemId).css("background", "#ddfcdc");
    }
});

function isEmptyOrSpaces(str) { //verificador de textos em branco
    return str === null || str.match(/^ *$/) !== null;
}