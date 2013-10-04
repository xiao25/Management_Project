Ext.Loader.setConfig({enabled: true});
Ext.define('HT.controller.GradeControllers', {
    extend: 'Ext.app.Controller',
    views: [
        'HT.view.Accordion',


        'HT.view.GradeView.Grade_inq',
        'HT.view.GradeView.GradAdd',
        'HT.view.GradeView.GradOperation',
        "HT.view.GradeView.GrdinqByStu_Grid",
        "HT.view.GradeView.inqstuname_form" ,
        'HT.view.GradeView.GridinqByCur_form',
        "HT.view.GradeView.GridinqByCur_Grid",
        "HT.view.GradeView.StuIds" ,
        "HT.view.GradeView.NewGriCur"



    ],
    stores: [

        'Grade' ,
        'InquCur',
        'CurNumstore',
        'CurNamestore' ,
        'StuNamestore'

    ],
    models: [
        'Students',
        'Courses',
        'Grade'
    ],
    //���ҵ����
    refs: [
        {
            ref: 'tab',

            selector: 'center'
        }
    ],
    init: function () {
        this.control({



            'GradOperation': {
                'edit': function () {

                    Ext.getStore("Grade").sync();
                }
            },


            //成绩操作
            'accordion button[name = operation_grd]': {

                click: function (o) {
                    if (Ext.ComponentQuery.query('Grade_inq').length == 0) {
                        this.getTab().add({
                            title: '成绩信息',
                            id: 'operationgrd',
                            layout: 'border',
                            items: [
                                {
                                    xtype: 'Grade_inq',
                                    region: 'north'

                                },
                                {
                                    xtype: 'GradOperation',
                                    region: 'center'

                                }
                            ],

                            closable: true,
                            closeAction: 'destroy',
                            autoDestory: true
                        }),
                            Ext.getStore("Grade").load();
                        Ext.ComponentQuery.query('GradOperation')[0].down('pagingtoolbar').moveFirst();
                        this.getTab().setActiveTab('operationgrd');
                    }

                    else {
                        this.getTab().setActiveTab('operationgrd');

                    }

                }

            },
            'Grade_inq button[name = submit]': {
                click: function (button) {

                    var values = button.up('form').getValues();
                    if (values.id == "")
                        values.id = 0;
                    Ext.getStore("Grade").load({
                        params: {
                            id: values.id

                        }
                    });


                }

            },


            'Grade_inq button[name = add]': {
                click: function (o) {

                    newview = Ext.create("HT.view.GradeView.GradAdd"),
                        newview.show();
                    var form = newview.down('form');
                    record = Ext.create('HT.model.Grade');
                    storenew = Ext.getStore("Grade");
                    storenew.add(record);
                    form.loadRecord(record);

                }
            },


            'GradAdd button[name = submit]': {
                click: function (button) {
                    var win = button.up('window');
                    var form = win.down('form');
                    if (form.getForm().isValid()) {
                        if (form.getValues().addmore == 1) {
                            var record = form.getRecord();
                            values = form.getValues();

                            record.set(values);


                            this.getStore('Grade').sync({
//                                success: function (form, action) {
//
//                                    Ext.Msg.alert(action.msg);
//                                    Ext.getStore("Grade").remove(action.data);
//                                }

                            });

                            form.form.reset();
                            record = Ext.create('HT.model.Grade'),
                                storenew = Ext.getStore("Grade");
                            storenew.add(record);
                            form.loadRecord(record);

                        }
                        else {
                            var record = form.getRecord();
                            values = form.getValues();

                            record.set(values);
                            //this.getStore('Students').loadData([record]);
                            this.getStore('Grade').sync();
                            form.close();
                            win.close();
                        }
                    }

                }
            },


            'accordion button[name=stuinq_grd]': {

                click: function (o) {
                    if (Ext.ComponentQuery.query('inqstuname_form').length == 0) {

                        this.getTab().add({
                            title: '学生课程查询',
                            id: 'inqstunamegrd',

                            layout: 'border',
                            items: [
                                {
                                    xtype: 'inqstuname_form',


                                    region: 'north'

                                },
                                {
                                    xtype: 'GrdinqByStu_Grid',
                                    region: 'center'

                                }
                            ],

                            closable: true,
                            closeAction: 'destroy',
                            autoDestory: true
                        }),

                            this.getTab().setActiveTab('inqstunamegrd');
                    }
                    else {
                        this.getTab().setActiveTab('inqstunamegrd');
                    }
                }

            },

            'inqstuname_form button[name=submit]': {
                click: function (button) {

                    var values = button.up('form').getValues();


                    if (values.stuname.length == 0 && values.kcm.length == 0) {
                        Ext.getStore('StuNamestore').load();
                        count = Ext.getStore('StuNamestore').getCount();
                        var stunames = Ext.getStore('StuNamestore').getRange(0, count);
                        stuname_array = new Array();
                        for (i = 0; i < count; i++)
                            stuname_array.push(stunames[i].data.stuname);

                        var stuname = Ext.encode(stuname_array);

                        Ext.getStore('CurNamestore').load();
                        count = Ext.getStore('CurNamestore').getCount();
                        var kcms = Ext.getStore('CurNamestore').getRange(0, count);
                        course_array = new Array();
                        for (i = 0; i < count; i++)
                            course_array.push(kcms[i].data.name);
                        var kcm = Ext.encode(course_array);
                    }
                    else if (values.kcm[0] == "" || values.kcm.length == 0) {
                        Ext.getStore('CurNamestore').load();
                        count = Ext.getStore('CurNamestore').getCount();
                        var kcms = Ext.getStore('CurNamestore').getRange(0, count);
                        course_array = new Array();
                        for (i = 0; i < count; i++)
                            course_array.push(kcms[i].data.name);
                        var kcm = Ext.encode(course_array);
                        var stuname = Ext.encode(values.stuname);
                    }
                    else if (values.stuname[0] == "" || values.stuname.length == 0) {

                        Ext.getStore('StuNamestore').load();
                        count = Ext.getStore('StuNamestore').getCount();
                        var stunames = Ext.getStore('StuNamestore').getRange(0, count);
                        stuname_array = new Array();
                        for (i = 0; i < count; i++)
                            stuname_array.push(stunames[i].data.stuname);
                        var stuname = Ext.encode(stuname_array);
                        var kcm = Ext.encode(values.kcm);
                    }
                    else {
                        var stuname = Ext.encode(values.stuname);
                        var kcm = Ext.encode(values.kcm);
                    }
                    Ext.Ajax.request({
                        async: false,
                        url: '/Grade/viewsbystu.action',

                        params: {
                            stuname: stuname,
                            kcm: kcm,
                            start: 0,
                            limit: 3
                        },
                        method: 'POST',
                        success: function (response) {
                            var json = Ext.JSON.decode(response.responseText); //获得后台传递json
                            if (json.data.length > 0) {


                                fields = "[{\"name\":'stuid',\"type\":'int'},{\"name\":'stuname',\"type\":'string'},";
                                for (x = 0; x < json.data[0].coursegrade.length; x++) {
                                    fields += "{\"name\":'course";
                                    fields += x;
                                    fields += "',\"type\":'string'},";
                                }
                                fields += "{\"name\": 'total',\"type\": 'int'}]";
                                fields = Ext.decode(fields);

                                // alert(fields);
                                var data = "["
                                for (z = 0; z < json.data.length; z++) {
                                    temp = "{stuid:" + json.data[z].stuid + ",stuname:'" + json.data[z].stuname + "'";
                                    for (x = 0; x < json.data[0].coursegrade.length; x++) {
                                        temp += (",course" + x + ":'" + json.data[z].coursegrade[x] + "'");


                                    }
                                    temp += (",total:" + json.data[z].total + "},");
                                    data += temp;
                                }
                                data += "]";
                                data = Ext.decode(data);


                                var cm = "[{\"header\":'学号',\"dataIndex\":'stuid'},{\"header\":'姓名',\"dataIndex\":'stuname'}";
                                for (x = 0; x < json.data[0].coursegrade.length; x++) {
                                    cm += ",{\"header\":'" + json.kcms[x] + "',\"dataIndex\":'course" + x + "'}";

                                }

                                cm += ",{\"header\":'总分',\"dataIndex\":'total'}, {xtype: 'rownumberer',header:'名次',width:100},]";
                                cm = Ext.decode(cm);


                                var store = Ext.create('Ext.data.Store', {
                                    fields: fields,//把json的fieldsNames赋给fields
                                    data: data,         //把json的data赋给data
                                    pageSize: 3,
                                    id: 'stugrdstore',
                                    autoLoad: false,
                                    sorters: {
                                        property: 'total',
                                        direction: 'DESC'
                                    },
                                    proxy: {
                                        type: 'ajax',
                                        url: '/Grade/viewsbystu.action',
                                        reader: {
                                            type: 'json',
                                            //idProperty: 'id',
                                            root: 'data',
                                            success: 'success',
                                            totalProperty: 'total'


                                        }
                                    }


                                });
                                Ext.getCmp("pagebar1").bindStore(store);
                                Ext.getCmp("GrdinqByStu_Grid").reconfigure(store, cm);  //定义grid的store和column

                            }


                        }

                    })
                }
            },


            'accordion button[name =inqcurname_grd]': {

                click: function (o) {

                    if (Ext.ComponentQuery.query('GridinqByCur_form').length == 0) {

                        this.getTab().add({
                            title: '课程成绩查询',

                            id: 'inqcrunamegrd',
                            layout: 'border',
                            items: [
                                {
//                                    xtype: 'GridinqByCur_form',
//                                    region: 'north'

                                    xtype: 'NewGriCur',
//                                    alias: 'widget.inqcrunameform',
                                    region: 'north'
//
//                                    items: [
//                                        {
//                                            xtype: 'trigger',
//
//                                            fieldLabel: '课程名称',
//
//                                            emptyText: '选择课程',
//                                            onTriggerClick: function () {
//
//                                                newview = Ext.create("HT.view.GradeView.StuIds"),
//
//                                                    Ext.getStore("newone").load({params: {query: ""}});
//
//                                                newview.show();
//                                            }
//
//
//
//                                        }],
//                                        buttons:[{
//
//                                                text: '查询',
//                                                name: 'submit'
//
//
//                                            }]
//


                                },
                                {
                                    xtype: 'GridinqByCur_Grid',
                                    region: 'center'

                                }
                            ],
                            closable: true,
                            closeAction: 'destroy',
                            autoDestory: true
                        }),
                            this.getTab().setActiveTab('inqcrunamegrd');
                    }
                    else {
                        this.getTab().setActiveTab('inqcrunamegrd');
                    }
                }
            },

            'NewGriCur button[name=submit]': {
                click: function (button) {
                    var form = button.up('form');
                    if (form.getForm().isValid()) {
                        Ext.getStore('InquCur').load();
                    }
                }
            },
            'Grade_inq button[name = delete]': {
                click: function (button) {
                    var checkbox = Ext.ComponentQuery.query('GradOperation')[0].getSelectionModel();
                    var array = checkbox.getSelection();
                    for (var i = 0; i < array.length; i++)
                        Ext.getStore("Grade").remove(array[i]);
                    Ext.getStore('Grade').sync();

                }
            },

            'StuIds button[name = submit]': {
                click: function (button) {
                    var data = button.up('form').getValues().kcm;
                    var index = button.up('window').down('grid').getStore().find("name", data);


                    var rec = button.up('window').down('grid').getStore().getAt(index);
                    var array = button.up('window').down('grid').getSelectionModel().getSelection();
                    array.push(rec);
                    button.up('window').down('grid').getSelectionModel().select(array);

                }
            },


            'StuIds button[name = finish]': {
                click: function (button) {


                    var array = button.up('window').down('grid').getSelectionModel().getSelection();
                    button.up('window').close();
                    var names = new Array();
                    for (var i = 0; i < array.length; i++)

                        names.push(array[i].data.name);


                    this.getTab().down('trigger').setValue(names);
                }
            }
        })

    }



});