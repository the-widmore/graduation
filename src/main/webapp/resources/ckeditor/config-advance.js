/**
 * Created by Carbon.Yrs on 2015/11/3.
 */

CKEDITOR.editorConfig = function (config) {


    config.toolbar = [
        { name: 'document', items: [ 'Source', '-', 'NewPage', 'Preview', 'Print', '-', 'Templates' ] },
        { name: 'clipboard', items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
        { name: 'editing', items: [ 'Find', 'Replace', '-', 'SelectAll' ] },
        { name: 'tools', items: [ 'Maximize', 'ShowBlocks' ] },
        '/',
        { name: 'paragraph', items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'] },
        { name: 'links', items: [ 'Link', 'Unlink'] },
        { name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar'] },
        { name: 'forms', items: [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton' ] },
        '/',
        { name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
        { name: 'styles', items: [ 'Styles', 'Format', 'Font', 'FontSize' ] },
        { name: 'colors', items: [ 'TextColor', 'BGColor' ] }
    ];
};
