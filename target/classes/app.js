(function (t)
    {
        function e(e)
        {
            for (var s, r, d = e[0], o = e[1], c = e[2], m = 0, u = []; m < d.length; m++)
            {
                r = d[m],
                Object.prototype.hasOwnProperty.call(i, r) && i[r] && u.push(i[r][0]),
                    i[r] = 0;
            }
            for (s in o)
            {
                Object.prototype.hasOwnProperty.call(o, s) && (t[s] = o[s]);
            }
            l && l(e);
            while (u.length)
            {
                u.shift()();
            }
            return n.push.apply(n, c || []),
                a()
        }

        function a()
        {
            for (var t, e = 0; e < n.length; e++)
            {
                for (var a = n[e], s = !0, d = 1; d < a.length; d++)
                {
                    var o = a[d];
                    0 !== i[o] && (s = !1)
                }
                s && (n.splice(e--, 1),
                    t = r(r.s = a[0]))
            }
            return t
        }

        var s = {}
            , i = {
            app: 0
        }
            , n = [];

        function r(e)
        {
            if (s[e])
            {
                return s[e].exports;
            }
            var a = s[e] = {
                i: e,
                l: !1,
                exports: {}
            };
            return t[e].call(a.exports, a, a.exports, r),
                a.l = !0,
                a.exports
        }

        r.m = t,
            r.c = s,
            r.d = function (t, e, a)
            {
                r.o(t, e) || Object.defineProperty(t, e, {
                    enumerable: !0,
                    get: a
                })
            }
            ,
            r.r = function (t)
            {
                "undefined" !== typeof Symbol && Symbol.toStringTag && Object.defineProperty(t, Symbol.toStringTag, {
                    value: "Module"
                }),
                    Object.defineProperty(t, "__esModule", {
                        value: !0
                    })
            }
            ,
            r.t = function (t, e)
            {
                if (1 & e && (t = r(t)),
                8 & e)
                {
                    return t;
                }
                if (4 & e && "object" === typeof t && t && t.__esModule)
                {
                    return t;
                }
                var a = Object.create(null);
                if (r.r(a),
                    Object.defineProperty(a, "default", {
                        enumerable: !0,
                        value: t
                    }),
                2 & e && "string" != typeof t)
                {
                    for (var s in t)
                    {
                        r.d(a, s, function (e)
                        {
                            return t[e]
                        }
                            .bind(null, s));
                    }
                }
                return a
            }
            ,
            r.n = function (t)
            {
                var e = t && t.__esModule ? function ()
                        {
                            return t["default"]
                        }
                        : function ()
                        {
                            return t
                        }
                ;
                return r.d(e, "a", e),
                    e
            }
            ,
            r.o = function (t, e)
            {
                return Object.prototype.hasOwnProperty.call(t, e)
            }
            ,
            r.p = "/";
        var d = window["webpackJsonp"] = window["webpackJsonp"] || []
            , o = d.push.bind(d);
        d.push = e,
            d = d.slice();
        for (var c = 0; c < d.length; c++)
        {
            e(d[c]);
        }
        var l = o;
        n.push([0, "chunk-vendors"]),
            a()
    }
)({
    0: function (t, e, a)
    {
        t.exports = a("56d7")
    },
    5107: function (t, e, a)
    {
    },
    "56d7": function (t, e, a)
    {
        "use strict";
        a.r(e);
        a("e260"),
            a("e6cf"),
            a("cca6"),
            a("a79d");
        var s = a("2b0e")
            , i = a("8c4f")
            , n = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                staticClass: "box"
            }, [a("div", {
                staticClass: "header"
            }, [t._v("题库")]), a("div", {
                staticClass: "pad10"
            }, t._l(t.cat, (function (e)
                {
                    return a("div", {
                        key: e.id,
                        staticClass: "item padh10"
                    }, [a("router-link", {
                        attrs: {
                            to: "cat/" + e.id
                        }
                    }, [t._v(t._s(e.title))])], 1)
                }
            )), 0)])
        }
            , r = []
            , d = {
            name: "tiku",
            data: function ()
            {
                return {
                    cat: [{
                        title: "基础医学",
                        id: 2
                    }, {
                        title: "临床医学",
                        id: 3
                    }, {
                        title: "护理专业",
                        id: 5
                    }, {
                        title: "药学专业",
                        id: 4
                    }, {
                        title: "中医专业",
                        id: 6
                    }, {
                        title: "预防专业",
                        id: 11
                    }, {
                        title: "口腔医学",
                        id: 13
                    }, {
                        title: "考研专区",
                        id: 9
                    }, {
                        title: "护士资格考试",
                        id: 7
                    }, {
                        title: "临床职业医师考试",
                        id: 10
                    }]
                }
            }
        }
            , o = d
            , c = a("2877")
            , l = Object(c["a"])(o, n, r, !1, null, null, null)
            , m = l.exports
            , u = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                staticClass: "box"
            }, [a("div", {
                staticClass: "header"
            }, [t._v(t._s(t.cat.title))]), a("div", {
                staticClass: "pad10"
            }, [0 == t.loaded ? a("div", {
                staticClass: "padh10"
            }, [t._v("loading")]) : t._e(), t._l(t.subjects, (function (e)
                {
                    return a("div", {
                        key: e.id,
                        staticClass: "item padh10"
                    }, [a("router-link", {
                        attrs: {
                            to: "/sub/" + e.id
                        }
                    }, [t._v(" " + t._s(e.title))])], 1)
                }
            ))], 2)])
        }
            , p = []
            , h = {
            name: "tiku",
            data: function ()
            {
                return {
                    subjects: [],
                    loaded: 0,
                    cat: {
                        id: 0,
                        title: "."
                    }
                }
            },
            mounted: function ()
            {
                var t = this;
                if (void 0 != this.$route.params.id)
                {
                    var e = this.$route.params.id
                        , a = this.$parent.getStorage("cat" + e);
                    if (a)
                    {
                        return this.loaded = 1,
                            this.subjects = a.subject,
                            void (this.cat = a.cat[0]);
                    }
                    this.$http.get("cat?id=" + e).then((function (a)
                        {
                            t.loaded = 1,
                                t.subjects = a.data.data.subject,
                                t.cat = a.data.data.cat[0],
                                t.$parent.setStorage("cat" + e, a.data.data, 6048e5)
                        }
                    ))
                }
            }
        }
            , v = h
            , f = Object(c["a"])(v, u, p, !1, null, null, null)
            , g = f.exports
            , w = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                staticClass: "box"
            }, [a("div", {
                staticClass: "header"
            }, [t._v(t._s(t.subject.s_title))]), t.loading ? a("div", {
                staticClass: "sep50"
            }, [t._v("加载中...")]) : t._e(), a("div", {
                staticClass: "pad10"
            }, [0 == t.isfav ? a("p", [a("el-button", {
                staticClass: "m-big-button",
                attrs: {
                    size: "mini",
                    type: "primary"
                },
                on: {
                    click: t.addFav
                }
            }, [t._v(t._s(0 == t.favnet ? "创建错题集" : "创建中..."))])], 1) : t._e(), t._l(t.chapters, (function (e)
                {
                    return a("div", {
                        key: e.id,
                        staticClass: "item padh10"
                    }, [a("router-link", {
                        attrs: {
                            to: "/q/" + e.c_subject + "/" + e.c_id + "/1"
                        }
                    }, [t._v(t._s(e.c_name))]), 1 == e.mistake ? a("router-link", {
                        attrs: {
                            to: "/q/" + e.c_subject + "/" + e.c_id + "/2"
                        }
                    }, [a("span", {
                        staticClass: "ogre-menu simple-menu"
                    }, [t._v("错题集")])]) : t._e()], 1)
                }
            ))], 2)])
        }
            , _ = []
            , q = {
            name: "tiku",
            data: function ()
            {
                return {
                    loading: 1,
                    chapters: [],
                    isfav: 1,
                    favnet: 0,
                    subject: {
                        s_id: 0,
                        s_title: "."
                    }
                }
            },
            mounted: function ()
            {
                var t = this;
                if (void 0 != this.$route.params.id)
                {
                    var e = this.$parent.getSession("sub" + this.$route.params.id);
                    if (e)
                    {
                        return this.loading = 0,
                            this.chapters = e.chapter,
                            this.subject = e.subject[0],
                            void (this.isfav = e.isfav);
                    }
                    this.$http.get("subject?id=" + this.$route.params.id).then((function (e)
                        {
                            t.loading = 0,
                                t.chapters = e.data.data.chapter,
                                t.subject = e.data.data.subject[0],
                                t.isfav = e.data.data.isfav,
                                t.$parent.setSession("sub" + t.$route.params.id, e.data.data)
                        }
                    ))
                }
            },
            methods: {
                addFav: function ()
                {
                    var t = this;
                    0 != this.$parent.login ? 1 != this.isfav ? (this.favnet = 1,
                        this.$http.post("fav", {
                            sid: this.subject.s_id
                        }).then((function (e)
                            {
                                if (1 == e.data.status && (t.$message({
                                    message: "创建成功",
                                    type: "success"
                                }),
                                    t.isfav = 1,
                                1 == t.$parent.loadFav))
                                {
                                    var a = {
                                        id: t.subject.s_id,
                                        title: t.subject.s_title,
                                        fid: e.data.data
                                    };
                                    t.$parent.fav.unshift(a)
                                }
                            }
                        ))) : this.$message({
                        message: "已经创建错题集",
                        type: "error"
                    }) : this.$message({
                        message: "请先登录",
                        type: "error"
                    })
                }
            }
        }
            , y = q
            , b = Object(c["a"])(y, w, _, !1, null, null, null)
            , $ = b.exports
            , C = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                attrs: {
                    id: "quiz"
                }
            }, [a("div", {
                staticClass: "pad10"
            }, t._l(t.label, (function (e)
                {
                    return a("span", {
                        key: e.id,
                        staticClass: "ogre-menu",
                        on: {
                            click: function (a)
                            {
                                return t.goto(e.id)
                            }
                        }
                    }, [t._v(t._s(e.label) + "(" + t._s(e.num) + ")")])
                }
            )), 0), a("div", {
                staticClass: "box"
            }, [a("div", {
                staticClass: "header"
            }, [t._v(" " + t._s(t.currentID + 1) + "/" + t._s(t.num) + ". " + t._s(t.current.pre) + t._s(t.current.title) + " ")]), a("quiz", {
                key: t.current.id,
                ref: "qm",
                attrs: {
                    qdata: t.current,
                    mode: t.mode
                },
                on: {
                    selected: t.selectEvent
                }
            }), a("div", [a("ul", {
                staticClass: "quiz-control"
            }, [a("li", [a("el-dropdown", {
                attrs: {
                    trigger: "click"
                },
                on: {
                    command: t.switchMode
                }
            }, [a("span", {
                staticClass: "icon-gear"
            }), a("el-dropdown-menu", {
                attrs: {
                    slot: "dropdown"
                },
                slot: "dropdown"
            }, [a("el-dropdown-item", {
                attrs: {
                    command: "0"
                }
            }, [t._v("做题模式")]), a("el-dropdown-item", {
                attrs: {
                    command: "1"
                }
            }, [t._v("阅读模式")])], 1)], 1)], 1), a("li", {
                on: {
                    click: t.pre
                }
            }, [t._v("上一题")]), a("li", {
                on: {
                    click: t.showAnswer
                }
            }, [t._v("显示答案")]), a("li", {
                on: {
                    click: t.next
                }
            }, [t._v("下一题")])])]), t.current.mode > 0 && t.current.qtype < 3 ? a("div", [t._v(t._s(t.current.note))]) : t._e()], 1), a("div", {
                staticClass: "sep20"
            }), a("comments", {
                ref: "cm",
                attrs: {
                    qdata: t.current,
                    qid: t.current.id
                }
            }), a("div", {
                staticClass: "sep50"
            })], 1)
        }
            , k = []
            , x = a("6d94")
            , A = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", [1 == t.qdata.qtype ? a("div", [t.qdata.a ? a("div", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && "A" == t.qdata.answer,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && "A" == t.qdata.answer
                },
                on: {
                    click: function (e)
                    {
                        return t.selectItem("A")
                    }
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "radio",
                    id: "ra",
                    name: "t" + t.qdata.id,
                    value: "A",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: t._q(t.qdata.myAnswer, "A")
                },
                on: {
                    change: function (e)
                    {
                        return t.$set(t.qdata, "myAnswer", "A")
                    }
                }
            }), a("label", {
                attrs: {
                    for: "ra"
                }
            }, [t._v(t._s(t.qdata.a))])]) : t._e(), t.qdata.b ? a("div", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && "B" == t.qdata.answer,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && "B" == t.qdata.answer
                },
                on: {
                    click: function (e)
                    {
                        return t.selectItem("B")
                    }
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "radio",
                    id: "rb",
                    name: "t" + t.qdata.id,
                    value: "B",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: t._q(t.qdata.myAnswer, "B")
                },
                on: {
                    change: function (e)
                    {
                        return t.$set(t.qdata, "myAnswer", "B")
                    }
                }
            }), a("label", {
                attrs: {
                    for: "rb"
                }
            }, [t._v(t._s(t.qdata.b))])]) : t._e(), t.qdata.c ? a("div", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && "C" == t.qdata.answer,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && "C" == t.qdata.answer
                },
                on: {
                    click: function (e)
                    {
                        return t.selectItem("C")
                    }
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "radio",
                    id: "rc",
                    name: "t" + t.qdata.id,
                    value: "C",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: t._q(t.qdata.myAnswer, "C")
                },
                on: {
                    change: function (e)
                    {
                        return t.$set(t.qdata, "myAnswer", "C")
                    }
                }
            }), a("label", {
                attrs: {
                    for: "rc"
                }
            }, [t._v(t._s(t.qdata.c))])]) : t._e(), t.qdata.d ? a("div", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && "D" == t.qdata.answer,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && "D" == t.qdata.answer
                },
                on: {
                    click: function (e)
                    {
                        return t.selectItem("D")
                    }
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "radio",
                    id: "rd",
                    name: "t" + t.qdata.id,
                    value: "D",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: t._q(t.qdata.myAnswer, "D")
                },
                on: {
                    change: function (e)
                    {
                        return t.$set(t.qdata, "myAnswer", "D")
                    }
                }
            }), a("label", {
                attrs: {
                    for: "rd"
                }
            }, [t._v(t._s(t.qdata.d))])]) : t._e(), t.qdata.e ? a("div", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && "E" == t.qdata.answer,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && "E" == t.qdata.answer
                },
                on: {
                    click: function (e)
                    {
                        return t.selectItem("E")
                    }
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "radio",
                    id: "re",
                    name: "t" + t.qdata.id,
                    value: "E",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: t._q(t.qdata.myAnswer, "E")
                },
                on: {
                    change: function (e)
                    {
                        return t.$set(t.qdata, "myAnswer", "E")
                    }
                }
            }), a("label", {
                attrs: {
                    for: "re"
                }
            }, [t._v(t._s(t.qdata.e))])]) : t._e()]) : t._e(), 2 == t.qdata.qtype ? a("div", [a("label", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && t.qdata.answer.indexOf("A") >= 0,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && t.qdata.answer.indexOf("A") >= 0
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "checkbox",
                    name: "t" + t.qdata.id,
                    value: "A",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: Array.isArray(t.qdata.myAnswer) ? t._i(t.qdata.myAnswer, "A") > -1 : t.qdata.myAnswer
                },
                on: {
                    change: function (e)
                    {
                        var a = t.qdata.myAnswer
                            , s = e.target
                            , i = !!s.checked;
                        if (Array.isArray(a))
                        {
                            var n = "A"
                                , r = t._i(a, n);
                            s.checked ? r < 0 && t.$set(t.qdata, "myAnswer", a.concat([n])) : r > -1 && t.$set(t.qdata, "myAnswer", a.slice(0, r).concat(a.slice(r + 1)))
                        }
                        else
                        {
                            t.$set(t.qdata, "myAnswer", i)
                        }
                    }
                }
            }), a("span", [t._v(t._s(t.qdata.a))])]), t.qdata.b ? a("label", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && t.qdata.answer.indexOf("B") >= 0,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && t.qdata.answer.indexOf("B") >= 0
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "checkbox",
                    name: "t" + t.qdata.id,
                    value: "B",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: Array.isArray(t.qdata.myAnswer) ? t._i(t.qdata.myAnswer, "B") > -1 : t.qdata.myAnswer
                },
                on: {
                    change: function (e)
                    {
                        var a = t.qdata.myAnswer
                            , s = e.target
                            , i = !!s.checked;
                        if (Array.isArray(a))
                        {
                            var n = "B"
                                , r = t._i(a, n);
                            s.checked ? r < 0 && t.$set(t.qdata, "myAnswer", a.concat([n])) : r > -1 && t.$set(t.qdata, "myAnswer", a.slice(0, r).concat(a.slice(r + 1)))
                        }
                        else
                        {
                            t.$set(t.qdata, "myAnswer", i)
                        }
                    }
                }
            }), a("span", [t._v(t._s(t.qdata.b))])]) : t._e(), t.qdata.c ? a("label", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && t.qdata.answer.indexOf("C") >= 0,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && t.qdata.answer.indexOf("C") >= 0
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "checkbox",
                    name: "t" + t.qdata.id,
                    value: "C",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: Array.isArray(t.qdata.myAnswer) ? t._i(t.qdata.myAnswer, "C") > -1 : t.qdata.myAnswer
                },
                on: {
                    change: function (e)
                    {
                        var a = t.qdata.myAnswer
                            , s = e.target
                            , i = !!s.checked;
                        if (Array.isArray(a))
                        {
                            var n = "C"
                                , r = t._i(a, n);
                            s.checked ? r < 0 && t.$set(t.qdata, "myAnswer", a.concat([n])) : r > -1 && t.$set(t.qdata, "myAnswer", a.slice(0, r).concat(a.slice(r + 1)))
                        }
                        else
                        {
                            t.$set(t.qdata, "myAnswer", i)
                        }
                    }
                }
            }), a("span", [t._v(t._s(t.qdata.c))])]) : t._e(), t.qdata.d ? a("label", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && t.qdata.answer.indexOf("D") >= 0,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && t.qdata.answer.indexOf("D") >= 0
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "checkbox",
                    name: "t" + t.qdata.id,
                    value: "D",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: Array.isArray(t.qdata.myAnswer) ? t._i(t.qdata.myAnswer, "D") > -1 : t.qdata.myAnswer
                },
                on: {
                    change: function (e)
                    {
                        var a = t.qdata.myAnswer
                            , s = e.target
                            , i = !!s.checked;
                        if (Array.isArray(a))
                        {
                            var n = "D"
                                , r = t._i(a, n);
                            s.checked ? r < 0 && t.$set(t.qdata, "myAnswer", a.concat([n])) : r > -1 && t.$set(t.qdata, "myAnswer", a.slice(0, r).concat(a.slice(r + 1)))
                        }
                        else
                        {
                            t.$set(t.qdata, "myAnswer", i)
                        }
                    }
                }
            }), a("span", [t._v(t._s(t.qdata.d))])]) : t._e(), t.qdata.e ? a("label", {
                staticClass: "selectItem",
                class: {
                    rightanswer: 1 == t.qdata.mode && t.qdata.answer.indexOf("E") >= 0,
                    wronganswer: (t.mode || 2 == t.qdata.mode) && t.qdata.answer.indexOf("E") >= 0
                }
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.qdata.myAnswer,
                    expression: "qdata.myAnswer"
                }],
                attrs: {
                    type: "checkbox",
                    name: "t" + t.qdata.id,
                    value: "E",
                    disabled: t.mode || t.qdata.mode
                },
                domProps: {
                    checked: Array.isArray(t.qdata.myAnswer) ? t._i(t.qdata.myAnswer, "E") > -1 : t.qdata.myAnswer
                },
                on: {
                    change: function (e)
                    {
                        var a = t.qdata.myAnswer
                            , s = e.target
                            , i = !!s.checked;
                        if (Array.isArray(a))
                        {
                            var n = "E"
                                , r = t._i(a, n);
                            s.checked ? r < 0 && t.$set(t.qdata, "myAnswer", a.concat([n])) : r > -1 && t.$set(t.qdata, "myAnswer", a.slice(0, r).concat(a.slice(r + 1)))
                        }
                        else
                        {
                            t.$set(t.qdata, "myAnswer", i)
                        }
                    }
                }
            }), a("span", [t._v(t._s(t.qdata.e))])]) : t._e(), a("div", {
                staticClass: "pad10"
            }, [a("el-button", {
                staticClass: "m-big",
                attrs: {
                    type: "primary",
                    size: "mini"
                },
                on: {
                    click: t.multSelect
                }
            }, [t._v("提交")])], 1)]) : t._e(), t.qdata.qtype > 2 ? a("div", [0 == t.mode && 2 != t.qdata.mode ? a("div", {
                staticClass: "pad10"
            }, [a("el-button", {
                staticClass: "m-big",
                attrs: {
                    type: "primary",
                    size: "mini"
                },
                on: {
                    click: t.showNote
                }
            }, [t._v("显示答案")])], 1) : t._e(), 2 == t.qdata.mode || 1 == t.mode ? a("div", {
                staticClass: "pad10 lh2"
            }, [t._v(t._s(t.qdata.note))]) : t._e()]) : t._e()])
        }
            , j = []
            , S = (a("a15b"),
            {
                props: ["qdata", "mode"],
                data: function ()
                {
                    return {
                        myAnswer: !1,
                        myAnswer2: []
                    }
                },
                mounted: function ()
                {
                    2 != this.qdata.qtype || this.qdata.myAnswer || (this.qdata.myAnswer = [])
                },
                methods: {
                    selectItem: function (t)
                    {
                        var e = this;
                        this.mode > 0 || this.qdata.mode > 0 || (this.qdata["myAnswer"] = t,
                            this.qdata["myAnswer"] == this.qdata.answer ? (this.qdata["mode"] = 1,
                                setTimeout((function ()
                                    {
                                        e.$emit("selected", 1)
                                    }
                                ), 200)) : (this.qdata["mode"] = 2,
                                this.$emit("selected", 2)),
                            this.$forceUpdate())
                    },
                    multSelect: function ()
                    {
                        var t = this;
                        if (!(this.mode > 0 || this.qdata.mode > 0))
                        {
                            var e = this.qdata["myAnswer"].sort().join("");
                            this.qdata.answer == e ? (this.qdata["mode"] = 1,
                                setTimeout((function ()
                                    {
                                        t.$emit("selected", 1)
                                    }
                                ), 200)) : (this.qdata["mode"] = 2,
                                this.$emit("selected", this.qdata.mode)),
                                this.$forceUpdate()
                        }
                    },
                    showNote: function ()
                    {
                        this.qdata["mode"] = 2,
                            this.$forceUpdate()
                    }
                }
            })
            , O = S
            , I = Object(c["a"])(O, A, j, !1, null, null, null)
            , N = I.exports
            , P = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return 1 == t.qdata.c_status ? a("div", {
                staticClass: "box"
            }, [a("div", {
                staticClass: "header"
            }, [t._v("评论")]), t._l(t.qdata.comments, (function (e)
                {
                    return a("div", {
                        key: e.id,
                        staticClass: "reply"
                    }, [a("div", {
                        staticClass: "link"
                    }, [t._v(t._s(e.uname) + "：")]), a("up", {
                        attrs: {
                            num: e.up,
                            rid: e.id,
                            qid: e.qid,
                            isup: e.isup,
                            uid: e.user
                        }
                    }), a("div", {
                        staticClass: "reply-content",
                        class: {
                            red: e.my
                        }
                    }, [t._v(t._s(e.content))])], 1)
                }
            )), a("addc", {
                attrs: {
                    qid: t.qid
                },
                on: {
                    commented: t.onComment
                }
            })], 2) : t._e()
        }
            , E = []
            , z = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                staticClass: "up right"
            }, [a("span", {
                class: [t.active ? t.up1 : t.up0],
                on: {
                    click: t.up
                }
            }), a("span", {
                staticClass: "up-num"
            }, [t._v(t._s(t.num))])])
        }
            , D = []
            , T = {
            props: ["num", "rid", "qid", "uid", "isup"],
            data: function ()
            {
                return {
                    up0: "icon-thumbs-o-up",
                    up1: "icon-thumbs-up",
                    active: !1
                }
            },
            created: function ()
            {
                this.num = parseInt(this.num),
                    this.active = 0 != this.isup
            },
            methods: {
                up: function ()
                {
                    var t = this;
                    if (this.active)
                    {
                        this.$message({
                            message: "赞到极致，不能更赞!",
                            center: !0,
                            type: "error"
                        });
                    }
                    else
                    {
                        var e = this.$root.$children[0].login
                            , a = this.$root.$children[0].user;
                        0 != e ? this.uid != a.id ? this.$http.put("up", {
                            rid: this.rid,
                            qid: this.qid,
                            uid: this.uid
                        }).then((function (e)
                            {
                                1 == e.data.status && (t.num++,
                                    t.active = !0)
                            }
                        )) : this.$message({
                            message: "别人赞才是真的赞",
                            center: !0,
                            type: "error"
                        }) : this.$message({
                            message: "请先登录",
                            center: !0,
                            type: "error"
                        })
                    }
                }
            }
        }
            , B = T
            , R = Object(c["a"])(B, z, D, !1, null, null, null)
            , U = R.exports
            , F = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                staticClass: "pad10"
            }, [a("p", [a("textarea", {
                directives: [{
                    name: "model",
                    rawName: "v-model.trim",
                    value: t.comment,
                    expression: "comment",
                    modifiers: {
                        trim: !0
                    }
                }],
                staticClass: "reply-ta",
                attrs: {
                    name: "comment",
                    placeholder: "参与讨论"
                },
                domProps: {
                    value: t.comment
                },
                on: {
                    input: function (e)
                    {
                        e.target.composing || (t.comment = e.target.value.trim())
                    },
                    blur: function (e)
                    {
                        return t.$forceUpdate()
                    }
                }
            })]), a("p", [a("span", {
                staticClass: "sep-h"
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.tid,
                    expression: "tid"
                }],
                attrs: {
                    type: "radio",
                    id: "type1",
                    name: "ctype",
                    value: "1"
                },
                domProps: {
                    checked: t._q(t.tid, "1")
                },
                on: {
                    change: function (e)
                    {
                        t.tid = "1"
                    }
                }
            }), a("label", {
                attrs: {
                    for: "type1"
                }
            }, [t._v("解析")])]), a("span", {
                staticClass: "sep-h"
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.tid,
                    expression: "tid"
                }],
                attrs: {
                    type: "radio",
                    id: "type2",
                    name: "ctype",
                    value: "2"
                },
                domProps: {
                    checked: t._q(t.tid, "2")
                },
                on: {
                    change: function (e)
                    {
                        t.tid = "2"
                    }
                }
            }), a("label", {
                attrs: {
                    for: "type2"
                }
            }, [t._v("疑问")])]), a("span", {
                staticClass: "sep-h"
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.tid,
                    expression: "tid"
                }],
                attrs: {
                    type: "radio",
                    id: "type3",
                    name: "ctype",
                    value: "3"
                },
                domProps: {
                    checked: t._q(t.tid, "3")
                },
                on: {
                    change: function (e)
                    {
                        t.tid = "3"
                    }
                }
            }), a("label", {
                attrs: {
                    for: "type3"
                }
            }, [t._v("报错")])]), a("span", {
                staticClass: "sep-h"
            }, [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.tid,
                    expression: "tid"
                }],
                attrs: {
                    type: "radio",
                    id: "type0",
                    name: "ctype",
                    value: "0"
                },
                domProps: {
                    checked: t._q(t.tid, "0")
                },
                on: {
                    change: function (e)
                    {
                        t.tid = "0"
                    }
                }
            }), a("label", {
                attrs: {
                    for: "type0"
                }
            }, [t._v("其他")])])]), a("el-button", {
                staticClass: "m-big-button",
                attrs: {
                    size: "mini",
                    type: "primary"
                },
                on: {
                    click: t.addComment
                }
            }, [t._v(t._s(0 == t.sending ? "提交" : "提交中.."))])], 1)
        }
            , J = []
            , M = (a("b0c0"),
            {
                props: ["qid"],
                data: function ()
                {
                    return {
                        tid: 0,
                        comment: "",
                        sending: 0
                    }
                },
                methods: {
                    addComment: function ()
                    {
                        var t = this
                            , e = this.$parent.$parent.info
                            , a = this.$root.$children[0].user;
                        if (this.$root.$children[0].login)
                        {
                            if (1 != this.sending)
                            {
                                if ("" != this.comment)
                                {
                                    if (this.comment)
                                    {
                                        var s = {
                                            sid: e.sid,
                                            cid: e.cid,
                                            qid: this.qid,
                                            type: this.tid,
                                            comment: this.comment
                                        };
                                        this.sending = 1,
                                            this.$http.post("comment", s).then((function (e)
                                                {
                                                    1 == e.data.status ? (s["user"] = a.id,
                                                        s["uname"] = a.name,
                                                        s["id"] = e.data.data,
                                                        s["content"] = s["comment"],
                                                        s["isup"] = 0,
                                                        s["up"] = 0,
                                                        s["my"] = 1,
                                                        t.$emit("commented", s),
                                                        t.$message.success("评论成功！"),
                                                        t.comment = "") : t.$message({
                                                        message: "系统错误，暂时无法评论",
                                                        center: !0,
                                                        type: "error"
                                                    }),
                                                        t.sending = 0
                                                }
                                            ))
                                    }
                                }
                                else
                                {
                                    this.$message({
                                        message: "请输入评论信息",
                                        center: !0,
                                        type: "error"
                                    })
                                }
                            }
                        }
                        else
                        {
                            this.$message({
                                message: "not login",
                                center: !0,
                                type: "error"
                            })
                        }
                    }
                }
            })
            , L = M
            , W = Object(c["a"])(L, F, J, !1, null, null, null)
            , G = W.exports
            , Q = {
            components: {
                up: U,
                addc: G
            },
            props: ["qdata", "qid"],
            mounted: function ()
            {
            },
            methods: {
                onComment: function (t)
                {
                    this.qdata.comments.push(t),
                        this.$forceUpdate()
                }
            }
        }
            , Y = Q
            , Z = Object(c["a"])(Y, P, E, !1, null, null, null)
            , H = Z.exports
            , K = {
            name: "qz",
            components: {
                quiz: N,
                comments: H
            },
            data: function ()
            {
                return {
                    info: {},
                    quiz: {},
                    num: 0,
                    current: {
                        title: "",
                        pre: "",
                        qtype: 1,
                        a: "",
                        b: "",
                        c: "",
                        type: 0,
                        id: 0,
                        comments: [],
                        c_status: 0
                    },
                    type: 0,
                    mode: 0,
                    fav: 0,
                    currentID: 0,
                    reply: [],
                    tip: "",
                    comment: [],
                    label: []
                }
            },
            mounted: function ()
            {
                var t = this
                    , e = this.$route.params.cid
                    , a = this.$route.params.sid
                    , s = this.$route.params.mode
                    , i = 1 == s ? "q" : "mistake";
                if (this.fav = this.checkFav(a),
                1 == this.fav && this.addWork(a, e),
                1 == s)
                {
                    var n = this.$parent.getStorage("q" + e);
                    if (n)
                    {
                        this.info = n.info;
                        var r = Object(x["a"])(n.quiz);
                        return this.quiz = JSON.parse(r),
                            this.current = this.quiz[this.currentID],
                            this.num = this.quiz.length,
                            void this.init()
                    }
                }
                this.$http.get(i + "?cid=" + e + "&sid=" + a).then((function (a)
                    {
                        t.info = a.data.data.info;
                        var i = Object(x["a"])(a.data.data.quiz);
                        t.quiz = JSON.parse(i),
                            t.current = t.quiz[t.currentID],
                            t.num = t.quiz.length,
                            t.init(),
                        1 == s && t.$parent.setStorage("q" + e, a.data.data, 6048e5)
                    }
                )).catch((function ()
                    {
                        t.$message({
                            message: "网络错误，请稍后重试",
                            center: !0,
                            type: "error"
                        })
                    }
                ))
            },
            methods: {
                init: function ()
                {
                    this.getTag();
                    var t = this.getProgress();
                    t && (this.goto(t),
                        this.$message("上次做到第" + (t + 1) + "题"))
                },
                checkFav: function (t)
                {
                    if (0 == this.$parent.login)
                    {
                        return 0;
                    }
                    var e = this.$parent.fav;
                    for (var a in e)
                    {
                        if (e[a]["id"] == t)
                        {
                            return 1;
                        }
                    }
                    return 0
                },
                addWork: function (t, e)
                {
                    this.$http.put("work", {
                        sid: t,
                        cid: e
                    })
                },
                selectEvent: function (t)
                {
                    var e = this;
                    if (1 == t)
                    {
                        this.next();
                    }
                    else
                    {
                        this.getComment();
                        var a = {
                            sid: this.info.sid,
                            cid: this.info.cid,
                            qid: this.current.id,
                            isfav: this.fav
                        };
                        if (1 != this.$parent.login)
                        {
                            return;
                        }
                        this.$http.put("mistake", a).then((function (t)
                            {
                                if (1 == t.data.status && e.$parent.login)
                                {
                                    var a = e.$parent.getSession("sub" + e.info.sid);
                                    if (a && a.isfav)
                                    {
                                        for (var s in a.chapter)
                                        {
                                            if (a.chapter[s].c_id == e.info.cid)
                                            {
                                                return a.chapter[s].mistake = 1,
                                                    void e.$parent.setSession("sub" + e.info.sid, a)
                                            }
                                        }
                                    }
                                }
                            }
                        ))
                    }
                },
                next: function ()
                {
                    this.goto(this.currentID + 1)
                },
                pre: function ()
                {
                    this.goto(this.currentID - 1)
                },
                goto: function (t)
                {
                    t < 0 ? this.$message("已是第一题") : t >= this.num ? this.$message("已是最后第一题") : t > 9 && 0 == this.$parent.login && 1 == this.$parent.lockTiku ? this.$messageBox.alert("请先登录", "提示") : t >= 0 && t < this.num && (this.currentID = t,
                        this.current = this.quiz[this.currentID],
                        this.saveProgress(t))
                },
                saveProgress: function (t)
                {
                    this.$parent.setStorage("pgs" + this.info.cid, t)
                },
                getProgress: function ()
                {
                    var t = this.$parent.getStorage("pgs" + this.info.cid);
                    return t ? parseInt(t) : 0
                },
                showAnswer: function ()
                {
                    this.current.mode = 2,
                        this.getComment(),
                        this.$refs.qm.$forceUpdate()
                },
                getComment: function ()
                {
                    var t = this;
                    1 != this.$parent.lockComment && (this.current.c_status && 1 == this.current.c_status ? this.$refs.cm.$forceUpdate() : this.$http.get("comment?qid=" + this.current.id).then((function (e)
                        {
                            t.current.comments = e.data.data,
                                t.current.c_status = 1,
                                t.$refs.cm.$forceUpdate()
                        }
                    )))
                },
                switchMode: function (t)
                {
                    this.mode = parseInt(t)
                },
                getTag: function ()
                {
                    for (var t = 0, e = [{
                        label: "单选",
                        id: 0,
                        num: 0
                    }, {
                        label: "多选",
                        id: 0,
                        num: 0
                    }, {
                        label: "名词解释",
                        id: 0,
                        num: 0
                    }, {
                        label: "问答",
                        id: 0,
                        num: 0
                    }], a = [], s = this.quiz.length, i = 0; i < s; i++)
                    {
                        var n = this.quiz[i].qtype;
                        if (n != t)
                        {
                            t = n,
                                e[n - 1].id = i;
                            var r = {
                                label: e[n - 1].label,
                                id: i,
                                num: 1
                            };
                            a.push(r)
                        }
                        else
                        {
                            a[a.length - 1].num++
                        }
                    }
                    this.label = a
                }
            }
        }
            , V = K
            , X = Object(c["a"])(V, C, k, !1, null, null, null)
            , tt = X.exports
            , et = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                staticClass: "box"
            }, [1 == t.mode ? a("mylogin") : t._e(), 2 == t.mode && this.$parent.wx && !this.$parent.lockReg ? a("myreg") : t._e(), 2 != t.mode || this.$parent.wx && !this.$parent.lockReg ? t._e() : a("wx"), 1 == t.mode ? a("p", {
                staticClass: "pad10 m-center"
            }, [a("span", {
                on: {
                    click: function (e)
                    {
                        t.mode = 2
                    }
                }
            }, [t._v("没有账号? 立即注册")])]) : t._e(), 2 == t.mode ? a("p", {
                staticClass: "pad10 m-center"
            }, [a("span", {
                on: {
                    click: function (e)
                    {
                        t.mode = 1
                    }
                }
            }, [t._v("已有账号? 点此登录")])]) : t._e()], 1)
        }
            , at = []
            , st = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", [a("div", {
                staticClass: "header bborder"
            }, [t._v("注册")]), a("div", {
                staticClass: "pad10"
            }, [a("p", [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model.lazy",
                    value: t.name,
                    expression: "name",
                    modifiers: {
                        lazy: !0
                    }
                }],
                staticClass: "m-big",
                attrs: {
                    id: "name",
                    type: "text",
                    placeholder: "用户名:4-18位字母或数字"
                },
                domProps: {
                    value: t.name
                },
                on: {
                    change: function (e)
                    {
                        t.name = e.target.value
                    }
                }
            })]), a("p", [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model.lazy",
                    value: t.email,
                    expression: "email",
                    modifiers: {
                        lazy: !0
                    }
                }],
                staticClass: "m-big",
                attrs: {
                    id: "email",
                    type: "text",
                    placeholder: "email:用于登录验证或找回密码"
                },
                domProps: {
                    value: t.email
                },
                on: {
                    change: function (e)
                    {
                        t.email = e.target.value
                    }
                }
            })]), a("p", [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.pwd1,
                    expression: "pwd1"
                }],
                staticClass: "m-big",
                attrs: {
                    id: "pwd1",
                    type: "password",
                    placeholder: "密码:6-18位"
                },
                domProps: {
                    value: t.pwd1
                },
                on: {
                    input: function (e)
                    {
                        e.target.composing || (t.pwd1 = e.target.value)
                    }
                }
            })]), a("p", [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.pwd2,
                    expression: "pwd2"
                }],
                staticClass: "m-big",
                attrs: {
                    id: "pwd2",
                    type: "password",
                    placeholder: "再次输入密码"
                },
                domProps: {
                    value: t.pwd2
                },
                on: {
                    input: function (e)
                    {
                        e.target.composing || (t.pwd2 = e.target.value)
                    }
                }
            })]), t.tip ? a("div", {
                staticClass: "ogre-alert error-alert marginh10"
            }, [t._v(t._s(t.tip))]) : t._e(), t.tip2 ? a("div", {
                staticClass: "ogre-alert error-alert marginh10"
            }, [t._v(t._s(t.tip2))]) : t._e(), a("el-button", {
                staticClass: "m-big",
                attrs: {
                    type: "primary",
                    size: "mini",
                    disabled: t.btn_off
                },
                on: {
                    click: t.submit
                }
            }, [t._v("注册")])], 1)])
        }
            , it = []
            , nt = (a("d3b7"),
            a("3ca3"),
            a("ddb0"),
            a("2b3d"),
            {
                name: "reg",
                data: function ()
                {
                    return {
                        name: "",
                        email: "",
                        pwd1: "",
                        pwd2: "",
                        btn_off: !1,
                        tip2: ""
                    }
                },
                computed: {
                    tip: function ()
                    {
                        var t = /^[A-Za-zd0-9_]{4,19}$/
                            , e = /^\w{3,}(\.\w+)*@[A-z0-9]+(\.[A-z]{2,5}){1,2}$/;
                        return "" == this.name || t.test(this.name) ? "" != this.pwd1 && this.pwd1.length < 6 ? "密码至少6位" : "" != this.pwd2 && this.pwd2 != this.pwd1 ? "两次输入密码不一致" : "" == this.email || e.test(this.email) ? "" : "email地址有误" : "登录名只能由字母或数字组成，4-18个字符"
                    },
                    ready: function ()
                    {
                        return "" == this.name || "" == this.pwd1 || "" == this.pwd2 || "" == this.email ? 0 : 1
                    }
                },
                methods: {
                    submit: function ()
                    {
                        var t = this;
                        if (1 != this.btn_off && "" == this.tip)
                        {
                            if (0 != this.ready)
                            {
                                this.tip2 = "",
                                    this.btn_off = !0;
                                var e = new URLSearchParams;
                                e.append("name", this.name),
                                    e.append("pwd1", this.pwd1),
                                    e.append("pwd2", this.pwd2),
                                    e.append("email", this.email),
                                    e.append("wx", this.$parent.$parent.wx),
                                    this.$http.post("reg", e).then((function (e)
                                        {
                                            0 == e.data.status ? (t.tip2 = e.data.errMsg,
                                                t.btn_off = !1) : t.tip2 = "注册成功！"
                                        }
                                    ))
                            }
                            else
                            {
                                this.$message.error("请填写完整")
                            }
                        }
                    }
                }
            })
            , rt = nt
            , dt = Object(c["a"])(rt, st, it, !1, null, null, null)
            , ot = dt.exports
            , ct = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", [a("div", {
                staticClass: "header bborder"
            }, [t._v("登录")]), a("div", {
                staticClass: "pad10"
            }, [a("p", [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.name,
                    expression: "name"
                }],
                staticClass: "m-big",
                attrs: {
                    id: "name",
                    type: "text",
                    autofocus: "autofocus",
                    placeholder: "用户名"
                },
                domProps: {
                    value: t.name
                },
                on: {
                    input: function (e)
                    {
                        e.target.composing || (t.name = e.target.value)
                    }
                }
            })]), a("p", [a("input", {
                directives: [{
                    name: "model",
                    rawName: "v-model",
                    value: t.pwd,
                    expression: "pwd"
                }],
                staticClass: "m-big",
                attrs: {
                    id: "pwd",
                    type: "password",
                    placeholder: "密码"
                },
                domProps: {
                    value: t.pwd
                },
                on: {
                    input: function (e)
                    {
                        e.target.composing || (t.pwd = e.target.value)
                    }
                }
            })]), t.tip ? a("div", {
                staticClass: "ogre-alert error-alert marginh10"
            }, [t._v(t._s(t.tip))]) : t._e(), a("el-button", {
                staticClass: "m-big",
                attrs: {
                    type: "primary",
                    size: "mini"
                },
                on: {
                    click: t.submit
                }
            }, [t._v(t._s(0 == t.btn_off ? "登录" : "登录中..."))])], 1)])
        }
            , lt = []
            , mt = {
            data: function ()
            {
                return {
                    name: "",
                    pwd: "",
                    tip: "",
                    btn_off: !1
                }
            },
            methods: {
                submit: function ()
                {
                    var t = this;
                    if ("" != this.name && "" != this.pwd)
                    {
                        this.btn_off = !0;
                        var e = new URLSearchParams;
                        e.append("name", this.name),
                            e.append("pwd", this.pwd),
                            this.$http.post("login", e).then((function (e)
                                {
                                    var a = t.$parent.$parent;
                                    0 == e.data.status ? (t.tip = "用户名或密码错误",
                                        t.btn_off = !1) : (t.tip = "登录成功",
                                        a.login = 1,
                                        a.user = e.data.data,
                                        setTimeout((function ()
                                            {
                                                t.$router.push("/")
                                            }
                                        ), 500))
                                }
                            ))
                    }
                    else
                    {
                        this.tip = "请输入用户名和密码"
                    }
                }
            }
        }
            , ut = mt
            , pt = Object(c["a"])(ut, ct, lt, !1, null, null, null)
            , ht = pt.exports
            , vt = function ()
        {
            var t = this
                , e = t.$createElement;
            t._self._c;
            return t._m(0)
        }
            , ft = [function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", [a("div", {
                staticClass: "header bborder"
            }, [t._v("注册")]), a("div", {
                staticClass: "pad10"
            }, [a("div", {
                staticClass: "center"
            }, [a("p", [a("img", {
                attrs: {
                    src: "/static/images/qr.jpg",
                    alt: ""
                }
            })]), a("p", [t._v("关注公众号“"), a("span", {
                staticClass: "red"
            }, [t._v("医学资料库")]), t._v("”")]), a("p", [t._v("回复“"), a("span", {
                staticClass: "red"
            }, [t._v("注册")]), t._v("”进入注册界面")])])])])
        }
        ]
            , gt = {}
            , wt = Object(c["a"])(gt, vt, ft, !1, null, null, null)
            , _t = wt.exports
            , qt = {
            name: "login",
            components: {
                myreg: ot,
                mylogin: ht,
                wx: _t
            },
            data: function ()
            {
                return {
                    mode: 1
                }
            },
            mounted: function ()
            {
                1 != this.$parent.login || this.$router.push("/me")
            }
        }
            , yt = qt
            , bt = Object(c["a"])(yt, et, at, !1, null, null, null)
            , $t = bt.exports
            , Ct = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                staticClass: "box"
            }, [1 == t.mode ? a("mylogin") : t._e(), 2 == t.mode && this.$parent.wx && !this.$parent.lockReg ? a("myreg") : t._e(), 2 != t.mode || this.$parent.wx && !this.$parent.lockReg ? t._e() : a("wx"), 1 == t.mode ? a("p", {
                staticClass: "pad10 m-center"
            }, [a("span", {
                on: {
                    click: function (e)
                    {
                        t.mode = 2
                    }
                }
            }, [t._v("没有账号? 立即注册")])]) : t._e(), 2 == t.mode ? a("p", {
                staticClass: "pad10 m-center"
            }, [a("span", {
                on: {
                    click: function (e)
                    {
                        t.mode = 1
                    }
                }
            }, [t._v("已有账号? 点此登录")])]) : t._e()], 1)
        }
            , kt = []
            , xt = {
            name: "reg",
            components: {
                myreg: ot,
                mylogin: ht,
                wx: _t
            },
            data: function ()
            {
                return {
                    mode: 2
                }
            },
            mounted: function ()
            {
                1 != this.$parent.login || this.$router.push("/me")
            }
        }
            , At = xt
            , jt = Object(c["a"])(At, Ct, kt, !1, null, null, null)
            , St = jt.exports
            , Ot = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                staticClass: "box"
            }, [a("div", {
                staticClass: "header"
            }, [t._v("我的题库")]), a("div", {
                staticClass: "pad10"
            }, [0 == t.subjects.length ? a("div", {
                staticClass: "ogre-alert error-alert"
            }, [t._v("您创建过错题集的科目会在这里显示，目前还没创建过错题集")]) : t._e(), t._l(t.subjects, (function (e)
                {
                    return a("div", {
                        key: e.id,
                        staticClass: "item padh10"
                    }, [a("router-link", {
                        attrs: {
                            to: "/sub/" + e.id
                        }
                    }, [t._v(" " + t._s(e.title))]), a("span", {
                        staticClass: "ogre-menu simple-menu item-tool m-show right",
                        on: {
                            click: function (a)
                            {
                                return t.deleteFav(e.fid)
                            }
                        }
                    }, [t._v(t._s(1 == e.d ? "删除中.." : "删除"))])], 1)
                }
            ))], 2)])
        }
            , It = []
            , Nt = (a("a434"),
            {
                name: "me",
                data: function ()
                {
                    return {
                        subjects: []
                    }
                },
                mounted: function ()
                {
                    var t = this;
                    0 != this.$parent.login ? this.$parent.loadFav ? this.subjects = this.$parent.fav : this.$http.get("fav").then((function (e)
                        {
                            t.$parent.fav = e.data.data,
                                t.$parent.loadFav = 1,
                                t.subjects = t.$parent.fav
                        }
                    )) : this.$router.push("/login")
                },
                methods: {
                    deleteFav: function (t)
                    {
                        var e = this
                            , a = ""
                            , s = {};
                        for (var i in this.subjects)
                        {
                            if (this.subjects[i].fid == t)
                            {
                                s = this.subjects[i],
                                    a = i;
                                break
                            }
                        }
                        this.subjects[a]["d"] = 1,
                            this.$forceUpdate(),
                            this.$http.delete("fav", {
                                data: {
                                    fid: t
                                }
                            }).then((function (t)
                                {
                                    1 == t.data.status && (e.subjects.splice(a, 1),
                                        e.updateSessionSubject(s.id))
                                }
                            ))
                    },
                    updateSessionSubject: function (t)
                    {
                        var e = this.$parent.getSession("sub" + t);
                        if (e)
                        {
                            for (var a in e.isfav = 0,
                                e.chapter)
                            {
                                e.chapter[a]["mistake"] = 0;
                            }
                            this.$parent.setSession("sub" + t, e)
                        }
                    }
                }
            })
            , Pt = Nt
            , Et = Object(c["a"])(Pt, Ot, It, !1, null, null, null)
            , zt = Et.exports
            , Dt = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                staticClass: "box"
            }, [a("wx")], 1)
        }
            , Tt = []
            , Bt = {
            name: "weixin",
            components: {
                wx: _t
            }
        }
            , Rt = Bt
            , Ut = Object(c["a"])(Rt, Dt, Tt, !1, null, null, null)
            , Ft = Ut.exports;
        s["default"].use(i["a"]);
        var Jt = [{
            path: "/",
            name: "Tiku",
            component: m,
            meta: {
                index: 1
            }
        }, {
            path: "/cat/:id",
            name: "Cat",
            meta: {
                index: 2
            },
            component: g
        }, {
            path: "/sub/:id",
            name: "Sub",
            meta: {
                index: 3
            },
            component: $
        }, {
            path: "/q/:sid/:cid/:mode",
            name: "Quiz",
            meta: {
                index: 4
            },
            component: tt
        }, {
            path: "/login",
            name: "Login",
            meta: {
                index: 5
            },
            component: $t
        }, {
            path: "/me",
            name: "Me",
            meta: {
                index: 0
            },
            component: zt
        }, {
            path: "/reg",
            name: "Reg",
            meta: {
                index: 0
            },
            component: St
        }, {
            path: "/wx",
            name: "Wx",
            meta: {
                index: 0
            },
            component: Ft
        }, {
            path: "*",
            redirect: "/"
        }]
            , Mt = new i["a"]({
            routes: Jt
        })
            , Lt = Mt
            , Wt = (a("9e1f"),
            a("450d"),
            a("6ed5"))
            , Gt = a.n(Wt)
            , Qt = (a("0fb7"),
            a("f529"))
            , Yt = a.n(Qt)
            , Zt = (a("960d"),
            a("defb"))
            , Ht = a.n(Zt)
            , Kt = (a("bd49"),
            a("18ff"))
            , Vt = a.n(Kt)
            , Xt = (a("cb70"),
            a("b370"))
            , te = a.n(Xt)
            , ee = (a("1951"),
            a("eedf"))
            , ae = a.n(ee);
        s["default"].use(ae.a),
            s["default"].use(te.a),
            s["default"].use(Vt.a),
            s["default"].use(Ht.a),
            s["default"].prototype.$message = Yt.a,
            s["default"].prototype.$messageBox = Gt.a;
        var se = function ()
        {
            var t = this
                , e = t.$createElement
                , a = t._self._c || e;
            return a("div", {
                attrs: {
                    id: "app"
                }
            }, [a("div", {
                attrs: {
                    id: "top"
                }
            }, [a("div", {
                staticClass: "top-content content"
            }, [a("router-link", {
                attrs: {
                    to: "/"
                }
            }, [t._v("医学题库")]), a("span", {
                staticClass: "right nav"
            }, [1 == t.login ? a("router-link", {
                attrs: {
                    to: "/me"
                }
            }, [t._v("我的")]) : t._e(), 0 == t.login ? a("router-link", {
                attrs: {
                    to: "/login"
                }
            }, [t._v("登录")]) : t._e()], 1)], 1)]), a("div", {
                staticClass: "content",
                attrs: {
                    id: "wrapper"
                }
            }, [a("transition", {
                attrs: {
                    name: t.transitionName
                }
            }, [a("router-view")], 1)], 1)])
        }
            , ie = []
            , ne = (a("c975"),
            a("4d63"),
            a("ac1f"),
            a("25f0"),
            a("466d"),
            a("53ca"))
            , re = {
            name: "app",
            watch: {
                $route: function (t, e)
                {
                    t.meta.index > e.meta.index ? this.transitionName = "slide-left" : this.transitionName = "slide-right"
                }
            },
            mounted: function ()
            {
                var t = this
                    , e = this.getCookie("uid")
                    , a = this.getCookie("name")
                    , s = this.getCookie("wx")
                    , i = this.hk();
                i ? (s && (this.wx = s),
                e && a && (this.login = 1,
                    this.user = {
                        id: e,
                        name: a
                    },
                    this.$http.get("fav").then((function (e)
                        {
                            t.fav = e.data.data,
                                t.loadFav = 1
                        }
                    ))),
                    this.cleanStorage(),
                    this.loadConf()) : document.getElementsByTagName("body")[0].innerText = ""
            },
            data: function ()
            {
                return {
                    transitionName: "",
                    login: 0,
                    user: {
                        id: 0,
                        name: ""
                    },
                    fav: [],
                    lockTiku: 1,
                    lockComment: 1,
                    lockReg: 1,
                    wx: 0,
                    loadFav: 0
                }
            },
            methods: {
                loadConf: function ()
                {
                    var t = this;
                    this.$http.get("conf").then((function (e)
                        {
                            1 == e.data.status && (t.lockTiku = e.data.data.lockTiku,
                                t.lockComment = e.data.data.lockComment,
                                t.lockReg = e.data.data.lockReg)
                        }
                    ))
                },
                hk: function ()
                {
                    var t = Object(x["b"])(document.domain)
                        , e = "d3d3Lm1lZHRpa3UuY29t";
                    return t == e
                },
                getCookie: function (t)
                {
                    var e, a = new RegExp("(^| )" + t + "=([^;]*)(;|$)");
                    return (e = document.cookie.match(a)) ? unescape(e[2]) : null
                },
                cleanStorage: function ()
                {
                    if (localStorage)
                    {
                        for (var t = new Date, e = t.getTime(), a = localStorage.length, s = 0; s < a; s++)
                        {
                            var i = localStorage.key(s)
                                , n = i.indexOf("_ttl");
                            if (n > -1)
                            {
                                var r = parseInt(localStorage.getItem(i));
                                r && r < e && (localStorage.removeItem(i.substr(0, n)),
                                    localStorage.removeItem(i))
                            }
                        }
                    }
                },
                getStorage: function (t)
                {
                    var e = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : "json";
                    if (localStorage)
                    {
                        var a = localStorage.getItem(t)
                            , s = localStorage.getItem(t + "_ttl");
                        if (s)
                        {
                            s = parseInt(s);
                            var i = new Date
                                , n = i.getTime();
                            if (s > 0 && s < n)
                            {
                                return null
                            }
                        }
                        return "json" == e && (a = JSON.parse(a)),
                            a
                    }
                    return null
                },
                setStorage: function (t, e)
                {
                    var a = arguments.length > 2 && void 0 !== arguments[2] ? arguments[2] : 0
                        , s = arguments.length > 3 && void 0 !== arguments[3] ? arguments[3] : "json";
                    if (localStorage)
                    {
                        if ("json" == s && (e = JSON.stringify(e)),
                            localStorage.setItem(t, e),
                        0 != a)
                        {
                            var i = new Date;
                            a = i.getTime() + a
                        }
                        localStorage.setItem(t + "_ttl", a)
                    }
                },
                setSession: function (t, e)
                {
                    if (sessionStorage)
                    {
                        var a = Object(ne["a"])(e);
                        "object" == a ? sessionStorage.setItem(t, JSON.stringify(e)) : sessionStorage.setItem(t, e)
                    }
                },
                getSession: function (t)
                {
                    var e = arguments.length > 1 && void 0 !== arguments[1] ? arguments[1] : "json";
                    if (sessionStorage)
                    {
                        var a = sessionStorage.getItem(t);
                        return a = "json" == e ? JSON.parse(a) : a,
                            a
                    }
                    return null
                }
            }
        }
            , de = re
            , oe = (a("6bfc"),
            Object(c["a"])(de, se, ie, !1, null, "2ceef886", null))
            , ce = oe.exports
            , le = a("73ef")
            , me = a.n(le);
        me.a.defaults.baseURL = "/api/",
            s["default"].prototype.$http = me.a,
            s["default"].config.productionTip = !1,
            new s["default"]({
                router: Lt,
                render: function (t)
                {
                    return t(ce)
                }
            }).$mount("#app")
    },
    "6bfc": function (t, e, a)
    {
        "use strict";
        a("5107")
    }
});
//# sourceMappingURL=app.34ea571e.js.map
