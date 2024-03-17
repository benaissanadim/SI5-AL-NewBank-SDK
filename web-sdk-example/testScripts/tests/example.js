"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
// main.ts
var newbank_sdk_1 = require("@teamb/newbank-sdk");
var newbank_sdk_2 = require("@teamb/newbank-sdk");
function main() {
    return __awaiter(this, void 0, void 0, function () {
        var retrySettings, _a, cardNumber, cvv, expiryDate, token, port, newbankSdk, paymentInfo, response, confirm_1, error_1;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0:
                    retrySettings = new newbank_sdk_1.RetrySettings({
                        retries: 2,
                        factor: 2,
                        minTimeout: 10,
                        maxTimeout: 15,
                    });
                    _a = process.argv, cardNumber = _a[2], cvv = _a[3], expiryDate = _a[4], token = _a[5], port = _a[6];
                    newbankSdk = new newbank_sdk_1.NewbankSdk(token, retrySettings);
                    if (!(cardNumber && cvv && expiryDate)) return [3 /*break*/, 5];
                    paymentInfo = {
                        cardNumber: cardNumber,
                        cvv: cvv,
                        expirationDate: expiryDate,
                        amount: '500',
                    };
                    response = void 0;
                    _b.label = 1;
                case 1:
                    _b.trys.push([1, 4, , 5]);
                    return [4 /*yield*/, newbankSdk.authorizePayment(paymentInfo)];
                case 2:
                    response = _b.sent();
                    return [4 /*yield*/, newbankSdk.confirmPayment(response.transactionId)];
                case 3:
                    confirm_1 = _b.sent();
                    console.log(confirm_1);
                    return [3 /*break*/, 5];
                case 4:
                    error_1 = _b.sent();
                    if (error_1 instanceof newbank_sdk_2.UnauthorizedError) {
                        console.error('Authorization failed:', error_1.message);
                    }
                    return [2 /*return*/];
                case 5: return [2 /*return*/];
            }
        });
    });
}
main();