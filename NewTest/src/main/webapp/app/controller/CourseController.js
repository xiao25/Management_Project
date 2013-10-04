/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/16/13
 * Time: 1:45 AM
 * To change this template use File | Settings | File Templates.
 */

Ext.Loader.setConfig({enabled: true});
Ext.define('HT.controller.CourseController', {
    extend: 'Ext.app.Controller',
    views: [
        'HT.view.Accordion',

        'HT.view.CourseView.Cour_inq' ,
        'HT.view.CourseView.CourseAdd' ,
        "HT.view.CourseView.CourseOperation"

    ],
    stores: [

        'Courses' ,
        'InquCur',
        'CurNumstore',
        'CurNamestore'
    ],
    models: [

        'Courses'

    ],
    refs: [
        {
            ref: 'tab',

            selector: 'center'
        }
    ],
    init: function () {
        this.control({
//            'CourseOperation': {
//                'edit': function () {
//
//                    Ext.getStore("Courses").sync();
//                }
//            },
            //课程页动作处理

            'accordion button[name = ope_cur]': {
                click: function (o) {
                    if (Ext.ComponentQuery.query('Cour_inq').length == 0) {
                        this.getTab().add({
                            title: '课程信息',
                            id: 'operationcur',
                            layout: 'border',
                            items: [
                                {
                                    xtype: 'Cour_inq',
                                    region: 'north'

                                },
                                {
                                    xtype: 'CourseOperation',
                                    region: 'center'
                                }
                            ],

                            closable: true,
                            closeAction: 'destroy',
                            autoDestory: true
                        }),
                            Ext.ComponentQuery.query('CourseOperation')[0].down('pagingtoolbar').moveFirst();
                        Ext.getStore("Courses").load();
                        this.getTab().setActiveTab('operationcur');
                    }
                    else {
                        this.getTab().setActiveTab('operationcur');

                    }
                }
            },

            'Cour_inq button[name = add]': {
                click: function (o) {

                    newview = Ext.create("HT.view.CourseView.CourseAdd"),
                        newview.show();
                    var form = newview.down('form');
                    record = Ext.create('HT.model.Courses');
                    storenew = Ext.getStore("Courses");
                    storenew.add(record);
                    form.loadRecord(record);

                }
            },
            'CourseAdd button[name = Submit]': {
                click: function (button) {
                    var win = button.up('window');
                    var form = win.down('form');

                    if (form.getValues().addmore == 1) {
                        var record = form.getRecord();
                        values = form.getValues();

                        record.set(values);

                        // this.getStore('Students').loadData([record]);
                        this.getStore('Courses').sync({
                            success: function (form, action) {

//                                Ext.Msg.alert(action.msg);
                                Ext.getStore("Courses").remove(action.data);
                            }

                        });

                        form.form.reset();
                        record = Ext.create('HT.model.Courses'),
                            storenew = Ext.getStore("Courses");
                        storenew.add(record);
                        form.loadRecord(record);

                    }
                    else {
                        var record = form.getRecord();
                        values = form.getValues();

                        record.set(values);
                        //this.getStore('Students').loadData([record]);
                        this.getStore('Courses').sync();
                        form.close();
                        win.close();
                    }


                }
            },


            'Cour_inq button[name = submit]': {
                click: function (button) {


                    Ext.getStore("Courses").load();


                }

            },


            'Cour_inq button[name = delete]': {
                click: function (button) {
                    var checkbox = Ext.ComponentQuery.query('CourseOperation')[0].getSelectionModel();
                    var array = checkbox.getSelection();
                    for (var i = 0; i < array.length; i++)
                        Ext.getStore("Courses").remove(array[i]);
                    Ext.getStore('Courses').sync();

                }
            },

            'Cour_inq button[name = update]': {
                click: function (button) {
                    var checkbox = Ext.ComponentQuery.query('CourseOperation')[0].getSelectionModel();
                    var lastrecord = checkbox.getLastSelected().getData();

                    var newview = Ext.create("HT.view.CourseView.UpdateCour");
                    var form = newview.down('form');
                    form.query('textfield[name="id"]')[0].setValue(lastrecord.id);
                    form.query('textfield[name="kcm"]')[0].setValue(lastrecord.kcm);
                    form.query('textfield[name="ach"]')[0].setValue(lastrecord.ach);

                    form.query('htmleditor[name="remarks"]')[0].setValue(lastrecord.remarks);

                    newview.show();


                }
            },
            'UpdateCour button[name = Submit]': {
                click: function (button) {
                    var win = button.up('window');
                    var form = win.down('form');
                    var values = form.getValues();

                    Ext.Ajax.request({
                        async: false,
                        url: '/Course/update.action',

                        params: {
                            data: Ext.encode(values)

                        },
                        method: 'POST',
                        success: function (response) {
                            var json = Ext.JSON.decode(response.responseText);
                            if (json.success == true) {
                                alert("更新成功！");
                                Ext.getStore("Courses").reload();
                                win.destroy();
                            }
                        }
                    })
                }
            }

        })
    }



});
