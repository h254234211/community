/*
* 提交评论
* */
function post() {
    var questionId = $("#question_id").val()
    var content = $("#comment_content").val()
    comment2target(questionId, 1, content);
}

function comment2target(targetId, type, content) {
    if (!content) {
        alert("评论不能为空");
        return;
    }
    $.ajax(
        {
            type: "POST",
            url: "/comment",
            contentType: "application/json",
            data: JSON.stringify({
                "parentId": targetId,
                "content": content,
                "type": type
            }),
            success: function (response) {
                if (response.code == 200) {
                    window.location.reload();
                } else {
                    if (response.code == 2003) {
                        var isAccepted = confirm(response.message);
                        if (isAccepted) {
                            window.open("https://github.com/login/oauth/authorize?client_id=2fb66f5fd821d4ec4896&redirect_uri=http://localhost:8887/callback&scope=user&state=1")
                            window.localStorage.setItem("closable", true);
                        }
                    } else {
                        alert(response.message);
                    }
                }
            },
            dataType: "json"
        }
    );
}

/*
* 评论其他评论
* */
function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    comment2target(commentId, 2, content);
}

/*
* 展开二级评论
* */
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);
    if (comments.hasClass("in")) {
        //折叠
        comments.removeClass("in");
        e.classList.remove("active");
    } else {
        //展开
        var subCommentContainer = $("#comment-" + id);
        comments.addClass("in");
        e.classList.add("active");
        if (subCommentContainer.children().length != 1) {
            comments.addClass("in");
            e.classList.add("active");
        } else {
            $.getJSON("/comment/" + id, function (data) {
                console.log(data)
                $.each(data.data.reverse(), function (index, comment) {
                    console.log(comment);

                    var mediaLeftElement = $("<div/>", {
                        "class": "media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-rounded",
                        "src": comment.user.avatarUrl
                    }));

                    var mediaBodyElement = $("<div/>", {
                        "class": "media-body"
                    }).append($("<h5/>", {
                        "class": "media-heading",
                        "html": comment.user.name
                    })).append($("<div/>", {
                        "html": comment.content
                    })).append($("<div/>", {
                        "class": "menu"
                    }).append($("<span/>", {
                        "class": "pull-right",
                        "html": moment(comment.gmtCreate).format('YYYY-MM-DD')
                    })));

                    var mediaElement = $("<div/>", {
                        "class": "media"
                    }).append(mediaLeftElement)
                        .append(mediaBodyElement);

                    var commentElement = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 sol-xs-12 comments",
                    }).append(mediaElement);

                    subCommentContainer.prepend(commentElement);
                });
            });
        }
    }
}

function selectTag(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();
    if (previous.indexOf(value) == -1) {
        if (previous) {
            $("#tag").val(previous + '，' + value);
        } else {
            $("#tag").val(value);
        }
    }
}

function showSelectTag() {
    $("#select-tag").show();
}